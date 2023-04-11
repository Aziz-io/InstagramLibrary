package com.example.insta_test.responses.feed;

import com.example.insta_test.models.media.timeline.TimelineMedia;
import com.example.insta_test.responses.IGPaginatedResponse;
import com.example.insta_test.responses.IGResponse;

import java.util.List;

import lombok.Data;

@Data
public class FeedUserResponse extends IGResponse implements IGPaginatedResponse {
    private List<TimelineMedia> items;
    private String next_max_id;
    private int num_results;

    public boolean isMore_available() {
        return next_max_id != null;
    }
}
