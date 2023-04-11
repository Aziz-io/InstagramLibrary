package com.example.insta_test.requests.status;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.IGResponse;

public class StatusGetViewableStatusesRequest extends IGGetRequest<IGResponse> {

    @Override
    public String path() {
        return "status/get_viewable_statuses/";
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

}
