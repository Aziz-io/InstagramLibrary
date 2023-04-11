package com.example.insta_test.requests.multipleaccounts;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.IGResponse;

public class MultipleAccountsGetAccountFamilyRequest extends IGGetRequest<IGResponse> {

    @Override
    public String path() {
        return "multiple_accounts/get_account_family/";
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

}
