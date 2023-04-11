package com.example.insta_test.utils;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.insta_test.IGClient;
import com.example.insta_test.exceptions.IGResponseException;
import com.example.insta_test.requests.challenge.ChallengeResetRequest;
import com.example.insta_test.requests.challenge.ChallengeSelectVerifyMethodRequest;
import com.example.insta_test.requests.challenge.ChallengeSendCodeRequest;
import com.example.insta_test.requests.challenge.ChallengeStateGetRequest;
import com.example.insta_test.responses.accounts.LoginResponse;
import com.example.insta_test.responses.challenge.Challenge;
import com.example.insta_test.responses.challenge.ChallengeStateResponse;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class IGChallengeUtils {
    public static final String TAG = IGChallengeUtils.class.getSimpleName();

    private IGChallengeUtils() {
    }

    private static LoginResponse handleException(Throwable t) {
        Log.i(TAG, t.getCause().toString());
        return IGResponseException.IGFailedResponse.of(t.getCause(), LoginResponse.class);
    }

    public static CompletableFuture<ChallengeStateResponse> requestState(IGClient client,
                                                                         Challenge challenge) {
        return new ChallengeStateGetRequest(challenge.getApi_path(), client.getGuid(),
                client.getDeviceId(), challenge.getChallenge_context())
                .execute(client);
    }

    public static CompletableFuture<ChallengeStateResponse> selectVerifyMethod(IGClient client,
                                                                               Challenge challenge,
                                                                               String method,
                                                                               boolean resend) {
        return new ChallengeSelectVerifyMethodRequest(challenge.getApi_path(), method, resend)
                .execute(client);
    }

    public static CompletableFuture<LoginResponse> selectVerifyMethodDelta(IGClient client,
                                                                           Challenge challenge,
                                                                           String method,
                                                                           boolean resend) {
        return new ChallengeSelectVerifyMethodRequest(challenge.getApi_path(), method, resend)
                .execute(client)
                .thenApply(res -> IGUtils.convertToView(res, LoginResponse.class));
    }

    public static CompletableFuture<LoginResponse> sendSecurityCode(IGClient client,
                                                                    Challenge challenge, String code) {
        return new ChallengeSendCodeRequest(challenge.getApi_path(), code).execute(client);
    }

    public static CompletableFuture<ChallengeStateResponse> resetChallenge(IGClient client,
                                                                           Challenge challenge) {
        return new ChallengeResetRequest(challenge.getApi_path()).execute(client);
    }

    public static LoginResponse resolveChallenge(@NonNull IGClient client,
                                                 @NonNull LoginResponse response,
                                                 @NonNull Callable<String> inputCode, int retries) {
        Challenge challenge = response.getChallenge();
        ChallengeStateResponse stateResponse = requestState(client, challenge).join();
        String name = stateResponse.getStep_name();

        if (name.equalsIgnoreCase("select_verify_method")) {
            // verify by phone or email
            selectVerifyMethod(client, challenge, stateResponse.getStep_data().getChoice(), false);
            Log.i(TAG, "select_verify_method option security code sent to "
                    + (stateResponse.getStep_data().getChoice().equals("1") ? "email" : "phone"));
            do {
                try {
                    response = sendSecurityCode(client, challenge, inputCode.call())
                            .exceptionally(IGChallengeUtils::handleException)
                            .join();
                } catch (Exception e) {
                    Log.i(TAG, e.toString());
                }
            } while (!response.getStatus().equalsIgnoreCase("ok") && --retries > 0);
        } else if (name.equalsIgnoreCase("delta_login_review")) {
            // 'This was me' option
            Log.i(TAG, "delta_login_review option sent choice 0");
            response = selectVerifyMethodDelta(client, challenge, "0", false)
                    .exceptionally(IGChallengeUtils::handleException)
                    .join();
        } else {
            // Unknown step_name
        }

        return response;

    }

    public static LoginResponse resolveChallenge(@NonNull IGClient client,
                                                 @NonNull LoginResponse response,
                                                 @NonNull Callable<String> inputCode) {
        return resolveChallenge(client, response, inputCode, 3);
    }

    public static LoginResponse resolveTwoFactor(@NonNull IGClient client,
                                                 @NonNull LoginResponse response,
                                                 @NonNull Callable<String> inputCode) {
        return resolveTwoFactor(client, response, inputCode, 3);
    }

    public static LoginResponse resolveTwoFactor(@NonNull IGClient client,
                                                 @NonNull LoginResponse response,
                                                 @NonNull Callable<String> inputCode, int retries) {
        String identifier = response.getTwo_factor_info().getTwo_factor_identifier();
        do {
            try {
                String code = inputCode.call();

                response = client.sendLoginRequest(code, identifier)
                        .exceptionally(IGChallengeUtils::handleException)
                        .join();
            } catch (Exception e) {
                Log.i(TAG, e.toString());
            }
        } while (!response.getStatus().equals("ok") && --retries > 0);

        return response;
    }
}
