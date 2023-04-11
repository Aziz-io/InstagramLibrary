package com.example.insta_test.responses.live;

import com.example.insta_test.responses.IGResponse;

import lombok.Data;

@Data
public class LiveStartResponse extends IGResponse {
    private String media_id;
}
