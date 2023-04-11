package com.example.insta_test.requests.live;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.live.LiveBroadcastHeartbeatResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LiveBroadcastHeartbeatRequest extends IGPostRequest<LiveBroadcastHeartbeatResponse> {
    @NonNull
    private String broadcast_id;

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new IGPayload();
    }

    @Override
    public String path() {
        return "live/" + broadcast_id + "/heartbeat_and_get_viewer_count/";
    }

    @Override
    public Class<LiveBroadcastHeartbeatResponse> getResponseType() {
        return LiveBroadcastHeartbeatResponse.class;
    }

}
