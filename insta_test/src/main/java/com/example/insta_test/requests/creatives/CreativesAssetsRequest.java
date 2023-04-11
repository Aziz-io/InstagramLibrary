package com.example.insta_test.requests.creatives;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.creatives.CreativesAssetsResponse;

import lombok.Data;

public class CreativesAssetsRequest extends IGPostRequest<CreativesAssetsResponse> {

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new CreativesAssetsPayload();
    }

    @Override
    public String path() {
        return "creatives/assets/";
    }

    @Override
    public Class<CreativesAssetsResponse> getResponseType() {
        return CreativesAssetsResponse.class;
    }

    @Data
    public static class CreativesAssetsPayload extends IGPayload {
        private final String type = "static_stickers";
    }
}
