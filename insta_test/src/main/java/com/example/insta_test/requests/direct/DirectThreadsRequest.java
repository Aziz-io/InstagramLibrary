package com.example.insta_test.requests.direct;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.direct.DirectThreadsResponse;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class DirectThreadsRequest extends IGGetRequest<DirectThreadsResponse> {
    @NonNull
    private String thread_id;
    private String cursor;

    @Override
    public String path() {
        return "direct_v2/threads/" + thread_id + "/";
    }

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("cursor", cursor);
    }

    @Override
    public Class<DirectThreadsResponse> getResponseType() {
        return DirectThreadsResponse.class;
    }

}
