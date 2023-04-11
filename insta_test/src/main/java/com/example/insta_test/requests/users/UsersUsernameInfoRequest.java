package com.example.insta_test.requests.users;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.users.UserResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsersUsernameInfoRequest extends IGGetRequest<UserResponse> {
    @NonNull
    private String username;

    @Override
    public String path() {
        return "users/" + username + "/usernameinfo/";
    }

    @Override
    public Class<UserResponse> getResponseType() {
        return UserResponse.class;
    }

}
