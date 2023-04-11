package com.example.insta_test.responses.igtv;

import com.example.insta_test.models.igtv.Channel;
import com.example.insta_test.responses.IGPaginatedResponse;
import com.example.insta_test.responses.IGResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;

@Data
public class IgtvBrowseFeedResponse extends IGResponse implements IGPaginatedResponse {
    private Channel my_channel;
    private List<Channel> channels;
    @JsonProperty("max_id")
    private String next_max_id;
    private boolean more_available;
}
