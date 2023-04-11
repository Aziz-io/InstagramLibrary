package com.example.insta_test.responses.accounts;


import com.example.insta_test.models.user.User;
import com.example.insta_test.responses.IGResponse;


public class AccountsUserResponse extends IGResponse {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
