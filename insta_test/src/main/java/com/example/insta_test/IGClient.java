package com.example.insta_test;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.example.insta_test.actions.IGClientActions;
import com.example.insta_test.exceptions.ExceptionallyHandler;
import com.example.insta_test.exceptions.IGLoginException;
import com.example.insta_test.exceptions.IGResponseException;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.models.user.Profile;
import com.example.insta_test.requests.IGRequest;
import com.example.insta_test.requests.accounts.AccountsLoginRequest;
import com.example.insta_test.requests.accounts.AccountsTwoFactorLoginRequest;
import com.example.insta_test.requests.qe.QeSyncRequest;
import com.example.insta_test.responses.IGResponse;
import com.example.insta_test.responses.accounts.LoginResponse;
import com.example.insta_test.utils.IGUtils;
import com.example.insta_test.utils.SerializableCookieJar;
import com.example.insta_test.utils.SerializeUtil;

import java.io.File;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import kotlin.Pair;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Data
@Slf4j
public class IGClient implements Serializable {
    private static final long serialVersionUID = -893265874836l;
    private final String $username;
    private final String $password;
    private transient String encryptionId, encryptionKey, authorization;
    @Accessors(chain = true)
    private transient OkHttpClient httpClient;
    private transient String sessionId;
    private transient IGClientActions actions;
    @Accessors(chain = true)
    private transient ExceptionallyHandler exceptionallyHandler;
    private String deviceId;
    private String guid;
    private String phoneId;
    @Setter(AccessLevel.PRIVATE)
    private boolean loggedIn = false;
    @Setter(AccessLevel.PRIVATE)
    private Profile selfProfile;
    @Accessors(chain = true)
    private IGDevice device = IGAndroidDevice.GOOD_DEVICES[0];


    public String get$username() {
        return $username;
    }

    public String get$password() {
        return $password;
    }

    public String getEncryptionId() {
        return encryptionId;
    }

    public void setEncryptionId(String encryptionId) {
        this.encryptionId = encryptionId;
    }

    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public OkHttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public IGClientActions getActions() {
        return actions;
    }

    public void setActions(IGClientActions actions) {
        this.actions = actions;
    }

    public ExceptionallyHandler getExceptionallyHandler() {
        return exceptionallyHandler;
    }

    public void setExceptionallyHandler(ExceptionallyHandler exceptionallyHandler) {
        this.exceptionallyHandler = exceptionallyHandler;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Profile getSelfProfile() {
        return selfProfile;
    }

    public void setSelfProfile(Profile selfProfile) {
        this.selfProfile = selfProfile;
    }

    public IGDevice getDevice() {
        return device;
    }


    public IGClient(String username, String password) {
        this(username, password, IGUtils.defaultHttpClientBuilder().build());
    }

    public IGClient(String username, String password, OkHttpClient client) {
        this.$username = username;
        this.$password = password;
        this.guid = IGUtils.randomUuid();
        this.phoneId = IGUtils.randomUuid();
        this.deviceId = IGUtils.generateDeviceId(username, password);
        this.httpClient = client;
        this.initializeDefaults();
    }

    private void initializeDefaults() {
        this.sessionId = IGUtils.randomUuid();
        this.actions = new IGClientActions(this);
        this.exceptionallyHandler = new ExceptionallyHandler() {

            @Override
            public <T> T handle(Throwable throwable, Class<T> type) {
                throw new CompletionException(throwable.getCause());
            }

        };
    }

    public IGClientActions actions() {
        return this.actions;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public CompletableFuture<LoginResponse> sendLoginRequest() {
        return new QeSyncRequest().execute(IGClient.this)
                .thenCompose(res -> {
                    IGUtils.sleepSeconds(1);
                    return new AccountsLoginRequest($username,
                            IGUtils.encryptPassword(this.$password, this.encryptionId,
                                    this.encryptionKey)).execute(this);
                })
                .thenApply((res) -> {
                    this.setLoggedInState(res);

                    return res;
                });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public CompletableFuture<LoginResponse> sendLoginRequest(String code, String identifier) {
        return new QeSyncRequest().execute(this)
                .thenCompose(res -> new AccountsTwoFactorLoginRequest($username,
                        IGUtils.encryptPassword(this.$password, this.encryptionId,
                                this.encryptionKey),
                        code,
                        identifier).execute(this))
                .thenApply((res) -> {
                    this.setLoggedInState(res);

                    return res;
                });
    }

    public <T extends IGResponse> CompletableFuture<T> sendRequest(@NonNull IGRequest<T> req) {
        CompletableFuture<Pair<Response, String>> responseFuture = new CompletableFuture<>();
        Log.e("Sending request : {}", req.formUrl(this).toString());
        this.httpClient.newCall(req.formRequest(this)).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException exception) {
                responseFuture.completeExceptionally(exception);
            }

            @Override
            public void onResponse(Call call, Response res) throws IOException {
                Log.e("Response for {} : {}", call.request().url().toString());
                try (ResponseBody body = res.body()) {
                    responseFuture.complete(new Pair<>(res, body.string()));
                }
            }

        });

        return responseFuture
                .thenApply(res -> {
                    setFromResponseHeaders(res.getFirst());
                    Log.e("Response for {} with body (truncated) : {}",
                            res.getFirst().request().url() +
                            IGUtils.truncate(res.getSecond()));

                    return req.parseResponse(res);
                })
                .exceptionally((tr) -> {
                    return this.exceptionallyHandler.handle(tr, req.getResponseType());
                });
    }

    private void setLoggedInState(LoginResponse state) {
        if (!state.getStatus().equals("ok"))
            return;
        this.loggedIn = true;
        this.selfProfile = state.getLogged_in_user();
        Log.e("Logged into {} ({})", selfProfile.getUsername() + selfProfile.getPk());
    }

    public String getCsrfToken() {
        return IGUtils.getCookieValue(this.getHttpClient().cookieJar(), "csrftoken")
                .orElse("missing");
    }

    public void setFromResponseHeaders(Response res) {
        Optional.ofNullable(res.header("ig-set-password-encryption-key-id"))
                .ifPresent(s -> this.encryptionId = s);
        Optional.ofNullable(res.header("ig-set-password-encryption-pub-key"))
                .ifPresent(s -> this.encryptionKey = s);
        Optional.ofNullable(res.header("ig-set-authorization"))
                .ifPresent(s -> this.authorization = s);
    }

    public IGPayload setIGPayloadDefaults(IGPayload load) {
        load.set_csrftoken(this.getCsrfToken());
        load.setDevice_id(this.deviceId);
        if (selfProfile != null) {
            load.set_uid(selfProfile.getPk().toString());
            load.set_uuid(this.guid);
        } else {
            load.setId(this.guid);
        }
        load.setGuid(this.guid);
        load.setPhone_id(this.phoneId);

        return load;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static IGClient deserialize(File clientFile, File cookieFile)
            throws ClassNotFoundException, IOException {
        return deserialize(clientFile, cookieFile, IGUtils.defaultHttpClientBuilder());
    }

    public static IGClient deserialize(File clientFile, File cookieFile,
            OkHttpClient.Builder clientBuilder) throws ClassNotFoundException, IOException {
        IGClient client = SerializeUtil.deserialize(clientFile, IGClient.class);
        CookieJar jar = SerializeUtil.deserialize(cookieFile, SerializableCookieJar.class);

        client.httpClient = clientBuilder
                .cookieJar(jar)
                .build();

        return client;
    }

    public void serialize(File clientFile, File cookieFile) throws IOException {
        SerializeUtil.serialize(this, clientFile);
        SerializeUtil.serialize(this.httpClient.cookieJar(), cookieFile);
    }

    private Object readResolve() throws ObjectStreamException {
        this.initializeDefaults();
        if (loggedIn)
            Log.e("Logged into {} ({})", selfProfile.getUsername() + selfProfile.getPk());
        return this;
    }

    @Accessors(fluent = true)
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Builder {
        private String  username;
        private String password;
        private OkHttpClient client;
        private IGDevice device = IGAndroidDevice.GOOD_DEVICES[0];
        private LoginHandler onChallenge;
        private LoginHandler onTwoFactor;
        private BiConsumer<IGClient, LoginResponse> onLogin = (client, login) -> {
        };

        public IGClient build() {
            return new IGClient(username, password, Optional.ofNullable(client)
                    .orElseGet(() -> IGUtils.defaultHttpClientBuilder().build())).setDevice(device);
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public IGClient simulatedLogin(Consumer<List<CompletableFuture<?>>> postLoginResponses)
                throws IGLoginException {
            IGClient client = build();
            client.actions.simulate().preLoginFlow().forEach(CompletableFuture::join);
            onLogin.accept(client, performLogin(client));
            postLoginResponses.accept(client.actions.simulate().postLoginFlow());

            return client;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public IGClient simulatedLogin() throws IGLoginException {
            return simulatedLogin((res) -> {
            });
        }

        public IGClient login() throws IGLoginException {
            IGClient client = build();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                onLogin.accept(client, performLogin(client));
            }

            return client;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        private LoginResponse performLogin(IGClient client) throws IGLoginException {
            LoginResponse response = client.sendLoginRequest()
                    .exceptionally(tr -> {
                        LoginResponse loginResponse =
                                IGResponseException.IGFailedResponse.of(tr.getCause(), LoginResponse.class);
                        if (loginResponse.getTwo_factor_info() != null && onTwoFactor != null) {
                            loginResponse = onTwoFactor.accept(client, loginResponse);
                        }
                        if (loginResponse.getChallenge() != null && onChallenge != null) {
                            loginResponse = onChallenge.accept(client, loginResponse);
                            client.setLoggedInState(loginResponse);
                        }

                        return loginResponse;
                    })
                    .join();

            if (!client.isLoggedIn()) {
                throw new IGLoginException(client, response);
            }

            return response;
        }

        @FunctionalInterface
        public static interface LoginHandler {
            public LoginResponse accept(IGClient client, LoginResponse t);
        }

    }
}
