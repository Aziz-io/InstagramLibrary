package com.example.insta_test.requests.accounts;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.accounts.LoginResponse;


import lombok.Getter;
import lombok.NonNull;


public class AccountsTwoFactorLoginRequest extends IGPostRequest<LoginResponse> {
    @NonNull
    private String username, password, code, identifier;

    public AccountsTwoFactorLoginRequest(String username, String password, String code) {
        this.username = username;
        this.password = password;
        this.code = code;
    }


    public AccountsTwoFactorLoginRequest(String username, String password, String code, String identifier) {
        this.username = username;
        this.password = password;
        this.code = code;
        this.identifier = identifier;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public IGPayload getPayload(IGClient client) {
        return new AccountsLoginRequest.LoginPayload(username, password) {
            @Getter
            private final String verification_code = code;
            @Getter
            private final String two_factor_identifier = identifier;
        };
    }

    @Override
    public String path() {
        return "accounts/two_factor_login/";
    }

    @Override
    public Class<LoginResponse> getResponseType() {
        return LoginResponse.class;
    }

}
