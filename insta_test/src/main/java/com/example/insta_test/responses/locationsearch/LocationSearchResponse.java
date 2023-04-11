package com.example.insta_test.responses.locationsearch;

import com.example.insta_test.models.location.Location;
import com.example.insta_test.responses.IGResponse;

import java.util.List;

import lombok.Data;

@Data
public class LocationSearchResponse extends IGResponse {
    private List<Location.Venue> venues;
    private String request_id;
    private String rank_token;
}
