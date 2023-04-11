package com.example.insta_test.requests.challenge;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.accounts.LoginResponse;


import lombok.Getter;
import lombok.NonNull;


public class ChallengeSendCodeRequest extends IGPostRequest<LoginResponse> {
    @NonNull
    private String path;
    @NonNull
    private String code;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ChallengeSendCodeRequest(String path, String code) {
        this.path = path;
        this.code = code;
    }

    @Override
    public IGPayload getPayload(IGClient client) {
        return new IGPayload() {
            @Getter
            private final String security_code = code;
        };
    }

    @Override
    public String path() {
        return path.substring(1);
    }

    @Override
    public Class<LoginResponse> getResponseType() {
        return LoginResponse.class;
    }

}
