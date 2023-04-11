package com.example.insta_test.requests.media;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.IGResponse;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MediaCommentUnlikeRequest extends IGPostRequest<IGResponse> {
    @NonNull
    private String _comment_id;

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new IGPayload() {
            @Getter
            private String comment_id = _comment_id;
        };
    }

    @Override
    public String path() {
        return String.format("media/%s/comment_unlike/", _comment_id);
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

}