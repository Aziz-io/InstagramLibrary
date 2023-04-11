package com.example.insta_test.requests.zr;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.IGResponse;

public class ZrTokenResultRequest extends IGGetRequest<IGResponse> {

    @Override
    public String path() {
        return "zr/token/result/";
    }

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("device_id", client.getDeviceId(), "custom_device_id",
                client.getGuid(), "fetch_reason", "token_stale");
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

}
