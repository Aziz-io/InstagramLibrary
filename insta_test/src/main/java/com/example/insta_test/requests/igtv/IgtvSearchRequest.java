package com.example.insta_test.requests.igtv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.igtv.IgtvSearchResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class IgtvSearchRequest extends IGPostRequest<IgtvSearchResponse> {
    private String _query;

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new IgtvSearchPayload();
    }

    @Override
    public String path() {
        return String.format("igtv/%s/", _query != null ? "search" : "suggested_searches");
    }

    @Override
    public Class<IgtvSearchResponse> getResponseType() {
        return IgtvSearchResponse.class;
    }

    @Data
    @JsonInclude(Include.NON_NULL)
    public class IgtvSearchPayload extends IGPayload {
        private String query = _query;
    }

}
