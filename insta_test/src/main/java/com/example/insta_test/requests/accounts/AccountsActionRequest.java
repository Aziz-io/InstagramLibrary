package com.example.insta_test.requests.accounts;

import androidx.annotation.NonNull;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.accounts.AccountsUserResponse;




public class AccountsActionRequest extends IGPostRequest<AccountsUserResponse> {
    @NonNull
    private AccountsAction action;

    public AccountsActionRequest(AccountsAction action) {
        this.action = action;
    }

    @NonNull
    public AccountsAction getAction() {
        return action;
    }

    public void setAction(@NonNull AccountsAction action) {
        this.action = action;
    }

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new IGPayload();
    }

    @Override
    public String path() {
        return "accounts/" + action.name().toLowerCase() + "/";
    }

    @Override
    public Class<AccountsUserResponse> getResponseType() {
        return AccountsUserResponse.class;
    }

    public static enum AccountsAction {
        SET_PRIVATE, SET_PUBLIC, REMOVE_PROFILE_PICTURE;
    }
}
