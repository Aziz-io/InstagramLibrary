package com.example.insta_test.requests.loom;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.IGResponse;

public class LoomFetchConfigRequest extends IGGetRequest<IGResponse> {

    @Override
    public String path() {
        return "loom/fetch_config/";
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

}
