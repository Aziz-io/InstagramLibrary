package com.example.insta_test.responses.discover;

import com.example.insta_test.models.discover.Cluster;
import com.example.insta_test.models.discover.SectionalItem;
import com.example.insta_test.responses.IGPaginatedResponse;
import com.example.insta_test.responses.IGResponse;

import java.util.List;

import lombok.Data;

@Data
public class DiscoverTopicalExploreResponse extends IGResponse implements IGPaginatedResponse {
    private List<SectionalItem> sectional_items;
    private String rank_token;
    private List<Cluster> clusters;
    private String next_max_id;
    private boolean more_available;
}
