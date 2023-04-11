package com.example.insta_test.requests.direct;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.direct.DirectGetPresenceResponse;

public class DirectGetPresenceRequest extends IGGetRequest<DirectGetPresenceResponse> {

    @Override
    public String path() {
        return "direct_v2/get_presence/";
    }

    @Override
    public Class<DirectGetPresenceResponse> getResponseType() {
        return DirectGetPresenceResponse.class;
    }

}
