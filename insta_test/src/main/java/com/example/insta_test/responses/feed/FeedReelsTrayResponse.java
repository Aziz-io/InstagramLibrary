package com.example.insta_test.responses.feed;


import com.example.insta_test.models.feed.Reel;
import com.example.insta_test.models.live.Broadcast;
import com.example.insta_test.responses.IGResponse;

import java.util.List;

import lombok.Data;

@Data
public class FeedReelsTrayResponse extends IGResponse {
    private List<Reel> tray;
    private List<Broadcast> broadcasts;
}
