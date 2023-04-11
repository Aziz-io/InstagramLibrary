package com.example.insta_test.requests.feed;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.requests.IGPaginatedRequest;
import com.example.insta_test.responses.feed.FeedSavedResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class FeedSavedRequest extends IGGetRequest<FeedSavedResponse>
        implements IGPaginatedRequest {
    @Setter
    private String max_id;

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("max_id", max_id);
    }

    @Override
    public String path() {
        return "feed/saved/";
    }

    @Override
    public Class<FeedSavedResponse> getResponseType() {
        return FeedSavedResponse.class;
    }

}
