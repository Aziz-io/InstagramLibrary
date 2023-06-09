package com.example.insta_test.responses.fbsearch;

import com.example.insta_test.responses.IGPageRankTokenResponse;
import com.example.insta_test.responses.IGResponse;

import java.util.List;

import lombok.Data;

@Data
public class FbsearchPlacesResponse extends IGResponse implements IGPageRankTokenResponse {

    private int num_results;
    private String rank_token;
    private String page_token;
    private String status;
    private boolean has_more;
    private List<SearchLocationLocation> items;

    @Data
    public static class SearchLocationLocation {
        private String title;
        private String subtitle;
        private FbsearchLocation location;
    }

    @Data
    public static class FbsearchLocation {
        private long pk;
        private long facebook_places_id;
        private String short_name;
        private String external_source;
        private String name;
        private String address;
        private String city;
        private double lng;
        private double lat;
    }
}
