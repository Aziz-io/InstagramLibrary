package com.example.insta_test.requests.accounts;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.accounts.LoginResponse;

import lombok.NonNull;


public class AccountsLoginRequest extends IGPostRequest<LoginResponse> {
    @NonNull
    private String username;
    @NonNull
    private String password;

    @Override
    public String path() {
        return "accounts/login/";
    }

    @Override
    public IGPayload getPayload(IGClient client) {
        return new LoginPayload(username, password);
    }

    @Override
    public Class<LoginResponse> getResponseType() {
        return LoginResponse.class;
    }

    public AccountsLoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class LoginPayload extends IGPayload {
        @NonNull
        private String username;
        @NonNull
        private String enc_password;
        private int login_attempt_account = 0;

        public LoginPayload(String username, String enc_password, int login_attempt_account) {
            this.username = username;
            this.enc_password = enc_password;
            this.login_attempt_account = login_attempt_account;
        }


        public LoginPayload(String username, String enc_password) {
            this.username = username;
            this.enc_password = enc_password;
        }

        public LoginPayload() {
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEnc_password() {
            return enc_password;
        }

        public void setEnc_password(String enc_password) {
            this.enc_password = enc_password;
        }

        public int getLogin_attempt_account() {
            return login_attempt_account;
        }

        public void setLogin_attempt_account(int login_attempt_account) {
            this.login_attempt_account = login_attempt_account;
        }
    }

}
