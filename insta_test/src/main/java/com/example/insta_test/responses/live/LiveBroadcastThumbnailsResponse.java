package com.example.insta_test.responses.live;

import com.example.insta_test.responses.IGResponse;

import java.util.List;

import lombok.Data;

@Data
public class LiveBroadcastThumbnailsResponse extends IGResponse {
    private List<String> thumbnails;
}
