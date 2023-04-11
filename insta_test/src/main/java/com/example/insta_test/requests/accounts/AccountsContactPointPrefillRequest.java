package com.example.insta_test.requests.accounts;

import com.example.insta_test.IGClient;
import com.example.insta_test.IGConstants;
import com.example.insta_test.models.IGBaseModel;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.IGResponse;

import lombok.Data;

public class AccountsContactPointPrefillRequest extends IGPostRequest<IGResponse> {

    @Override
    public String baseApiUrl() {
        return IGConstants.B_BASE_API_URL;
    }

    @Override
    protected IGBaseModel getPayload(IGClient client) {
        return new IGPayload();
    }

    @Override
    public String path() {
        return "accounts/contact_point_prefill/";
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

    @Data
    private static class PrePayload extends IGBaseModel {
        private final String phone_id;
        private final String usage = "prefill";
    }

}
