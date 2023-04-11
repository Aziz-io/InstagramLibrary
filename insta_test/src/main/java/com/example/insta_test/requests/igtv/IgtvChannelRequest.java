package com.example.insta_test.requests.igtv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPaginatedRequest;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.igtv.IgtvChannelResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
public class IgtvChannelRequest extends IGPostRequest<IgtvChannelResponse>
        implements IGPaginatedRequest {
    @NonNull
    private String _id;
    @Setter
    private String max_id;

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new IgtvChannelPayload();
    }

    @Override
    public String path() {
        return "igtv/channel/";
    }

    @Override
    public Class<IgtvChannelResponse> getResponseType() {
        return IgtvChannelResponse.class;
    }

    @Data
    @JsonInclude(Include.NON_NULL)
    public class IgtvChannelPayload extends IGPayload {
        private String id = _id;
        @JsonProperty("max_id")
        private String _max_id = max_id;
    }

}
