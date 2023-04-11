package com.example.insta_test.requests.challenge;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGBaseModel;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.challenge.ChallengeStateResponse;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChallengeSendPhonenumberRequest extends IGPostRequest<ChallengeStateResponse> {
    @NonNull
    private final String path;
    @NonNull
    private final String _phone_number;
    
    @Override
    protected IGBaseModel getPayload(IGClient client) {
        return new IGPayload() {
            @Getter
            private String phone_number = _phone_number; 
        };
    }

    @Override
    public String path() {
        return path.substring(1);
    }

    @Override
    public Class<ChallengeStateResponse> getResponseType() {
        return ChallengeStateResponse.class;
    }

}
