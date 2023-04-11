package com.example.insta_test.requests.challenge;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.challenge.ChallengeStateResponse;

import lombok.NonNull;


public class ChallengeStateGetRequest extends IGGetRequest<ChallengeStateResponse> {
    @NonNull
    private String path, guid, device_id,challenge_context;


    public ChallengeStateGetRequest(String path, String guid, String device_id, String challenge_context) {
        this.path = path;
        this.guid = guid;
        this.device_id = device_id;
        this.challenge_context = challenge_context;
    }

    @Override
    public String path() {
        return path.substring(1);
    }

    @Override
    public String getQueryString(IGClient client) {
        return this.mapQueryString("guid", guid, "device_id", device_id,"challenge_context",challenge_context);
    }

    @Override
    public Class<ChallengeStateResponse> getResponseType() {
        return ChallengeStateResponse.class;
    }

}
