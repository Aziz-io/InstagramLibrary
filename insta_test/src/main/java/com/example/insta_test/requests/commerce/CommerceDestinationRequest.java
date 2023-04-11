package com.example.insta_test.requests.commerce;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.requests.IGPaginatedRequest;
import com.example.insta_test.responses.commerce.CommerceDestinationResponse;






public class CommerceDestinationRequest extends IGGetRequest<CommerceDestinationResponse>
        implements IGPaginatedRequest {


    public CommerceDestinationRequest() {
    }

    public CommerceDestinationRequest(String max_id) {
        this.max_id = max_id;
    }

    public String getMax_id() {
        return max_id;
    }

    @Override
    public void setMax_id(String max_id) {
        this.max_id = max_id;
    }

    private String max_id = "0";

    @Override
    public String path() {
        return "commerce/destination/";
    }

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("max_id", max_id, "cluster_id", "shopping");
    }

    @Override
    public Class<CommerceDestinationResponse> getResponseType() {
        return CommerceDestinationResponse.class;
    }

}
