package com.example.insta_test.requests.challenge;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.challenge.ChallengeStateResponse;


import lombok.NonNull;


public class ChallengeResetRequest extends IGPostRequest<ChallengeStateResponse> {
    @NonNull
    private String path;

    public ChallengeResetRequest(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public IGPayload getPayload(IGClient client) {
        return new IGPayload();
    }

    @Override
    public String path() {
        return path.replace("/challenge/", "challenge/reset/");
    }

    @Override
    public Class<ChallengeStateResponse> getResponseType() {
        return ChallengeStateResponse.class;
    }

}
