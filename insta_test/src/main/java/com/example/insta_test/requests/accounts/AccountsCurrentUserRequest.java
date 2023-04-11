package com.example.insta_test.requests.accounts;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.accounts.AccountsUserResponse;

public class AccountsCurrentUserRequest extends IGGetRequest<AccountsUserResponse> {

    @Override
    public String path() {
        return "accounts/current_user/";
    }

    @Override
    public Class<AccountsUserResponse> getResponseType() {
        return AccountsUserResponse.class;
    }

}
