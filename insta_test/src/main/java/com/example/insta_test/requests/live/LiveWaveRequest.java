package com.example.insta_test.requests.live;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.IGResponse;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LiveWaveRequest extends IGPostRequest<IGResponse> {
    @NonNull
    private String broadcast_id, _viewer_id;

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new IGPayload() {
            @Getter
            private String viewer_id = _viewer_id;
        };
    }

    @Override
    public String path() {
        return "live/" + broadcast_id + "/wave/";
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

}
