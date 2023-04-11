package com.example.insta_test.requests.media;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.IGResponse;

public class MediaBlockedRequest extends IGGetRequest<IGResponse> {

    @Override
    public String path() {
        return "media/blocked/";
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

}
