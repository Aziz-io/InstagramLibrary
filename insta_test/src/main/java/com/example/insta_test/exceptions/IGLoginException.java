package com.example.insta_test.exceptions;

import com.example.insta_test.IGClient;
import com.example.insta_test.responses.accounts.LoginResponse;


import lombok.Getter;

@Getter
public class IGLoginException extends IGResponseException {
    private final IGClient client;
    private final LoginResponse loginResponse;

    public IGLoginException(IGClient client, LoginResponse body) {
        super(body);
        this.client = client;
        this.loginResponse = body;
    }

}
