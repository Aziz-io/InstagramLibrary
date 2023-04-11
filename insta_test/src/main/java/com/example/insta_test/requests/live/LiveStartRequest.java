package com.example.insta_test.requests.live;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.live.LiveStartResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class LiveStartRequest extends IGPostRequest<LiveStartResponse> {
    private String broadcastId;
    private boolean sendNotification;

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new IGPayload() {
            @Getter
            private boolean should_send_notifications = sendNotification;
        };
    }

    @Override
    public String path() {
        return "live/" + broadcastId + "/start/";
    }

    @Override
    public Class<LiveStartResponse> getResponseType() {
        return LiveStartResponse.class;
    }

}
