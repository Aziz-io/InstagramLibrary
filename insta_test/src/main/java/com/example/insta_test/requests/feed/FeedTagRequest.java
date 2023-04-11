package com.example.insta_test.requests.feed;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.requests.IGPaginatedRequest;
import com.example.insta_test.responses.feed.FeedTagResponse;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
public class FeedTagRequest extends IGGetRequest<FeedTagResponse>
        implements IGPaginatedRequest {
    @NonNull
    private String tag;
    @Setter
    private String max_id;

    @Override
    public String path() {
        return "feed/tag/" + tag + "/";
    }

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("max_id", max_id);
    }

    @Override
    public Class<FeedTagResponse> getResponseType() {
        return FeedTagResponse.class;
    }

}
