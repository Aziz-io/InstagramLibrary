package com.example.insta_test.requests.live;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.IGResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LiveBroadcastInfoRequest extends IGGetRequest<IGResponse> {
    @NonNull
    private String _broadcast_id;

    @Override
    public String path() {
        return "live/" + _broadcast_id + "/info/";
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

}
