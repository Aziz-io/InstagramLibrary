package com.example.insta_test.requests.live;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.IGResponse;

public class LiveGetQuestionsRequest extends IGGetRequest<IGResponse> {

    @Override
    public String path() {
        return "live/get_questions/";
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

}
