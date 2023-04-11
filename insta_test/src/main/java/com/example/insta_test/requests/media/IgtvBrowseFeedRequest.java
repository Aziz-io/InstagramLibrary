package com.example.insta_test.requests.media;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.requests.IGPaginatedRequest;
import com.example.insta_test.responses.igtv.IgtvBrowseFeedResponse;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
public class IgtvBrowseFeedRequest extends IGGetRequest<IgtvBrowseFeedResponse>
        implements IGPaginatedRequest {
    @Setter
    private String max_id;
    @Setter
    private long min_timestamp;

    @Override
    public String path() {
        return "igtv/browse_feed/";
    }

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("max_id", max_id, "min_timestamp", String.valueOf(min_timestamp));
    }

    @Override
    public Class<IgtvBrowseFeedResponse> getResponseType() {
        return IgtvBrowseFeedResponse.class;
    }

    @Override
    public void setMax_id(String s) {

    }

}
