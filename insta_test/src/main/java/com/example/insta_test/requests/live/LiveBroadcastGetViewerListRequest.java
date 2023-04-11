package com.example.insta_test.requests.live;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.live.LiveBroadcastGetViewerListResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LiveBroadcastGetViewerListRequest
        extends IGGetRequest<LiveBroadcastGetViewerListResponse> {
    @NonNull
    private String broadcast_id;

    @Override
    public String path() {
        return "live/" + broadcast_id + "/get_viewer_list/";
    }

    @Override
    public Class<LiveBroadcastGetViewerListResponse> getResponseType() {
        return LiveBroadcastGetViewerListResponse.class;
    }

}
