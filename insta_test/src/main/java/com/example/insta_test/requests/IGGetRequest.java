package com.example.insta_test.requests;

import com.example.insta_test.IGClient;
import com.example.insta_test.responses.IGResponse;

import okhttp3.Request;

public abstract class IGGetRequest<T extends IGResponse> extends IGRequest<T> {

    @Override
    public Request formRequest(IGClient client) {
        Request.Builder req = new Request.Builder()
                .url(this.formUrl(client));
        this.applyHeaders(client, req);

        return req.build();
    }
}
