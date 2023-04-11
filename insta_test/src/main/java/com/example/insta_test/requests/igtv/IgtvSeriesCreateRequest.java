package com.example.insta_test.requests.igtv;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.igtv.IgtvSeriesResponse;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IgtvSeriesCreateRequest extends IGPostRequest<IgtvSeriesResponse> {
    @NonNull
    private String _title, _description;

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new IgtvSeriesCreatePayload();
    }

    @Override
    public String path() {
        return "igtv/series/create/";
    }

    @Override
    public Class<IgtvSeriesResponse> getResponseType() {
        return IgtvSeriesResponse.class;
    }

    @Data
    public class IgtvSeriesCreatePayload extends IGPayload {
        private String title = _title;
        private String description = _description;
    }

}
