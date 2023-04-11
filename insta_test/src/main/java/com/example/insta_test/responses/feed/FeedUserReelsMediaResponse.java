package com.example.insta_test.responses.feed;

import com.example.insta_test.models.feed.Reel;
import com.example.insta_test.responses.IGResponse;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Data;

@Data
public class FeedUserReelsMediaResponse extends IGResponse {
    @JsonUnwrapped
    private Reel reel;
}
