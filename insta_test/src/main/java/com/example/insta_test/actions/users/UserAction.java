package com.example.insta_test.actions.users;

import com.example.insta_test.IGClient;
import com.example.insta_test.actions.feed.FeedIterable;
import com.example.insta_test.models.friendships.Friendship;
import com.example.insta_test.models.user.User;
import com.example.insta_test.requests.friendships.FriendshipsActionRequest;
import com.example.insta_test.requests.friendships.FriendshipsActionRequest.FriendshipsAction;
import com.example.insta_test.requests.friendships.FriendshipsFeedsRequest;
import com.example.insta_test.requests.friendships.FriendshipsFeedsRequest.FriendshipsFeeds;
import com.example.insta_test.requests.friendships.FriendshipsShowRequest;
import com.example.insta_test.responses.feed.FeedUsersResponse;
import com.example.insta_test.responses.friendships.FriendshipStatusResponse;
import com.example.insta_test.responses.friendships.FriendshipsShowResponse;

import java.util.concurrent.CompletableFuture;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserAction {
    @NonNull
    private IGClient client;
    @NonNull
    @Getter
    private User user;

    public FeedIterable<FriendshipsFeedsRequest, FeedUsersResponse> followersFeed() {
        return new FeedIterable<>(client, () ->
                new FriendshipsFeedsRequest(user.getPk(), FriendshipsFeeds.FOLLOWERS));
    }

    public FeedIterable<FriendshipsFeedsRequest, FeedUsersResponse> followingFeed() {
        return new FeedIterable<>(client, () ->
                new FriendshipsFeedsRequest(user.getPk(), FriendshipsFeeds.FOLLOWING));
    }

    public CompletableFuture<Friendship> getFriendship() {
        return new FriendshipsShowRequest(user.getPk()).execute(client)
                .thenApply(FriendshipsShowResponse::getFriendship);
    }

    public CompletableFuture<FriendshipStatusResponse> action(FriendshipsAction action) {
        return new FriendshipsActionRequest(user.getPk(), action).execute(client);
    }
}
