package com.example.insta_test.responses.igtv;

import com.example.insta_test.responses.IGResponse;

import lombok.Data;

@Data
public class IgtvSeriesResponse extends IGResponse {
    private String id;
    private String title;
    private String description;
}
