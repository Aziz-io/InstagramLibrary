package com.example.insta_test.requests.live;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.live.LiveBroadcastCommentResponse;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LiveBroadcastCommentRequest extends IGPostRequest<LiveBroadcastCommentResponse> {
    @NonNull
    private String broadcast_id, _message;

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new LiveCommentPayload();
    }

    @Override
    public String path() {
        return "live/" + broadcast_id + "/comment/";
    }

    @Override
    public Class<LiveBroadcastCommentResponse> getResponseType() {
        return LiveBroadcastCommentResponse.class;
    }

    @Data
    public class LiveCommentPayload extends IGPayload {
        private String comment_text = _message;
    }

}
