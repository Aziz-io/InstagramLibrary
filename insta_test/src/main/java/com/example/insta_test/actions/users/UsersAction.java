package com.example.insta_test.actions.users;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.user.User;
import com.example.insta_test.requests.users.UsersInfoRequest;
import com.example.insta_test.requests.users.UsersSearchRequest;
import com.example.insta_test.requests.users.UsersUsernameInfoRequest;
import com.example.insta_test.responses.users.UserResponse;
import com.example.insta_test.responses.users.UsersSearchResponse;

import java.util.concurrent.CompletableFuture;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsersAction {
    @NonNull
    private IGClient client;

    public CompletableFuture<UserAction> findByUsername(String username) {
        return new UsersUsernameInfoRequest(username).execute(client)
                .thenApply(response -> new UserAction(client, response.getUser()));
    }



    public CompletableFuture<User> info(long pk) {
        return new UsersInfoRequest(pk).execute(client)
                .thenApply(UserResponse::getUser);
    }

    public CompletableFuture<UsersSearchResponse> search(String query) {
        return new UsersSearchRequest(query).execute(client);
    }

}
