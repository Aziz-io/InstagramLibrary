package com.example.insta_test.requests.direct;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.IGResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DirectThreadsDeleteItemRequest extends IGPostRequest<IGResponse> {
    @NonNull
    private String _thread_id;
    @NonNull
    private String _item_id;

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new IGPayload();
    }

    @Override
    public String path() {
        return String.format("direct_v2/threads/%s/items/%s/delete/", _thread_id, _item_id);
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

}
