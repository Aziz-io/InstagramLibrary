package com.example.insta_test.requests.friendships;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.requests.IGPaginatedRequest;
import com.example.insta_test.responses.feed.FeedUsersResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class FriendshipsPendingRequest extends IGGetRequest<FeedUsersResponse>
        implements IGPaginatedRequest {
    @Setter
    private String max_id;

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("max_id", max_id);
    }

    @Override
    public String path() {
        return "friendships/pending/";
    }

    @Override
    public Class<FeedUsersResponse> getResponseType() {
        return FeedUsersResponse.class;
    }

}
