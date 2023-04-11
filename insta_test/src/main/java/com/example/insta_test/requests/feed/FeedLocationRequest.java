package com.example.insta_test.requests.feed;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.requests.IGPaginatedRequest;
import com.example.insta_test.responses.feed.FeedLocationResponse;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
public class FeedLocationRequest extends IGGetRequest<FeedLocationResponse>
        implements IGPaginatedRequest {
    @NonNull
    private Long location;
    @Setter
    private String max_id;

    @Override
    public String path() {
        return "feed/location/" + location + "/";
    }

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("max_id", max_id);
    }

    @Override
    public Class<FeedLocationResponse> getResponseType() {
        return FeedLocationResponse.class;
    }

}
