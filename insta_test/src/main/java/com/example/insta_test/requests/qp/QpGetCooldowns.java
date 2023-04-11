package com.example.insta_test.requests.qp;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.IGResponse;
import com.example.insta_test.utils.IGUtils;

public class QpGetCooldowns extends IGGetRequest<IGResponse> {

    @Override
    public String path() {
        return "qp/get_cooldowns/";
    }

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("signature", IGUtils.generateSignature("{}"));
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

}
