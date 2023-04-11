package com.example.insta_test.requests.live;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.IGResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LiveQuestionDeactivateRequest extends IGPostRequest<IGResponse> {
    @NonNull
    private String broadcast_id;
    @NonNull
    private String qid;

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new IGPayload();
    }

    @Override
    public String path() {
        return String.format("live/%s/question/%s/deactivate/", broadcast_id, qid);
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

}
