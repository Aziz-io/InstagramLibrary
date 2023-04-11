package com.example.insta_test.requests.users;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.users.UserResponse;



public class UsersInfoRequest extends IGGetRequest<UserResponse> {
    private long userId;


    public UsersInfoRequest(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String path() {
        return "users/" + userId + "/info/?from_module=blended_search";
    }

    @Override
    public Class<UserResponse> getResponseType() {
        return UserResponse.class;
    }

}
