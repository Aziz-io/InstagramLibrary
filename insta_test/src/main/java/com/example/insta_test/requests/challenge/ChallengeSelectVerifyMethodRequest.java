package com.example.insta_test.requests.challenge;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.challenge.ChallengeStateResponse;

import lombok.Getter;
import lombok.NonNull;


public class ChallengeSelectVerifyMethodRequest extends IGPostRequest<ChallengeStateResponse> {
    @NonNull
    private final String path;
    @NonNull
    private final String _choice;
    private final boolean resend;


    public ChallengeSelectVerifyMethodRequest(String path, String _choice, boolean resend) {
        this.path = path;
        this._choice = _choice;
        this.resend = resend;
    }

    public String getPath() {
        return path;
    }

    public String get_choice() {
        return _choice;
    }

    public boolean isResend() {
        return resend;
    }

    @Override
    public IGPayload getPayload(IGClient client) {
        return new IGPayload() {
            @Getter
            private final String choice = _choice;
        };
    }

    @Override
    public String path() {
        return !resend ? path.substring(1) : path.replace("/challenge/", "challenge/replay/");
    }

    @Override
    public Class<ChallengeStateResponse> getResponseType() {
        return ChallengeStateResponse.class;
    }

}
