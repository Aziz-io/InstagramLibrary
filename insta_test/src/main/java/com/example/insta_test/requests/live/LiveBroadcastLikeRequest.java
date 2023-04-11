package com.example.insta_test.requests.live;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.live.LiveBroadcastLikeResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class LiveBroadcastLikeRequest extends IGPostRequest<LiveBroadcastLikeResponse> {
    @NonNull
    private String broadcast_id;
    private int count = 1;

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new IGPayload() {
            @Getter
            private int user_like_count = count;
        };
    }

    @Override
    public String path() {
        return "live/" + broadcast_id + "/like/";
    }

    @Override
    public Class<LiveBroadcastLikeResponse> getResponseType() {
        return LiveBroadcastLikeResponse.class;
    }

}
