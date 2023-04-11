package com.example.insta_test.responses.highlights;

import com.example.insta_test.models.feed.Reel;
import com.example.insta_test.responses.IGResponse;

import lombok.Data;

@Data
public class HighlightsCreateReelResponse extends IGResponse {
    private Reel reel;
}
