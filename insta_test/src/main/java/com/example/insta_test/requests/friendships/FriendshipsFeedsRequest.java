package com.example.insta_test.requests.friendships;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.requests.IGPaginatedRequest;
import com.example.insta_test.responses.feed.FeedUsersResponse;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
public class FriendshipsFeedsRequest extends IGGetRequest<FeedUsersResponse>
        implements IGPaginatedRequest {
    @NonNull
    private Long _id;
    @NonNull
    private FriendshipsFeeds action;
    @Setter
    private String max_id;
    @Setter
    private long min_timestamp;

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("max_id", max_id);
    }

    @Override
    public String path() {
        return String.format("friendships/%s/%s/", _id, action.name().toLowerCase());
    }

    @Override
    public Class<FeedUsersResponse> getResponseType() {
        return FeedUsersResponse.class;
    }


    public static enum FriendshipsFeeds {
        FOLLOWERS, FOLLOWING;
    }
}