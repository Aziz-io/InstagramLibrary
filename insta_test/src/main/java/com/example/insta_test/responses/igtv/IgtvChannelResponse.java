package com.example.insta_test.responses.igtv;

import com.example.insta_test.models.igtv.Channel;
import com.example.insta_test.responses.IGPaginatedResponse;
import com.example.insta_test.responses.IGResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Data;

@Data
public class IgtvChannelResponse extends IGResponse implements IGPaginatedResponse {
    @JsonUnwrapped
    private Channel channel;
    @JsonProperty("max_id")
    private String next_max_id;
    private boolean more_available;
}
