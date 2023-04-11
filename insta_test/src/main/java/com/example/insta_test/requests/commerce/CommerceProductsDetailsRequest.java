package com.example.insta_test.requests.commerce;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.commerce.CommerceProductsDetailsResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommerceProductsDetailsRequest extends IGGetRequest<CommerceProductsDetailsResponse> {
    @NonNull
    private String product_id, merchant_id;

    @Override
    public String path() {
        return "commerce/products/" + product_id + "/details/";
    }

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("merchant_id", merchant_id);
    }

    @Override
    public Class<CommerceProductsDetailsResponse> getResponseType() {
        return CommerceProductsDetailsResponse.class;
    }

}
