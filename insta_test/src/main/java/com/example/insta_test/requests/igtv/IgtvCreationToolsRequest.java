package com.example.insta_test.requests.igtv;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.IGResponse;

public class IgtvCreationToolsRequest extends IGGetRequest<IGResponse> {

    @Override
    public String path() {
        return "igtv/igtv_creation_tools/";
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }
}
