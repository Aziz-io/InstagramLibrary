package com.example.insta_test.responses.feed;

import com.example.insta_test.models.feed.Reel;
import com.example.insta_test.models.live.Broadcast;
import com.example.insta_test.responses.IGResponse;

import lombok.Data;

@Data
public class FeedUserStoryResponse extends IGResponse {
    private Reel reel;
    private Broadcast broadcast;
}
