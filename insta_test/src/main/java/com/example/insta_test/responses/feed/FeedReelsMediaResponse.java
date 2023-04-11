package com.example.insta_test.responses.feed;

import com.example.insta_test.models.feed.Reel;
import com.example.insta_test.responses.IGResponse;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class FeedReelsMediaResponse extends IGResponse {
    @JsonUnwrapped
    private Map<String, Reel> reels = new HashMap<String, Reel>();
}
