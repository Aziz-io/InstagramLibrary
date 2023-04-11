package com.example.insta_test.requests.feed;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.requests.IGPaginatedRequest;
import com.example.insta_test.responses.feed.FeedUserResponse;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
public class FeedUserRequest extends IGGetRequest<FeedUserResponse>
        implements IGPaginatedRequest {
    @NonNull
    private Long pk;
    @Setter
    private String max_id;

    @Override
    public String path() {
        return "feed/user/" + pk + "/";
    }

    @Override
    public String getQueryString(IGClient client) {
        return this.mapQueryString("max_id", max_id);
    }

    @Override
    public Class<FeedUserResponse> getResponseType() {
        return FeedUserResponse.class;
    }

}
