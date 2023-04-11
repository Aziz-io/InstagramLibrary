package com.example.insta_test.requests.accounts;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.IGResponse;

public class AccountsLogoutRequest extends IGPostRequest<IGResponse> {

    @Override
    public String path() {
        return "accounts/logout/";
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new IGPayload();
    }

}
