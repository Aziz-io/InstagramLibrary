package com.example.insta_test.requests.live;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.live.LiveBroadcastGetCommentResponse;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class LiveBroadcastGetCommentRequest extends IGGetRequest<LiveBroadcastGetCommentResponse> {
    @NonNull
    private String broadcast_id;
    private long last_ts;

    @Override
    public String path() {
        return "live/" + broadcast_id + "/get_comment/";
    }

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("last_comment_ts", String.valueOf(last_ts));
    }

    @Override
    public Class<LiveBroadcastGetCommentResponse> getResponseType() {
        return LiveBroadcastGetCommentResponse.class;
    }

}
