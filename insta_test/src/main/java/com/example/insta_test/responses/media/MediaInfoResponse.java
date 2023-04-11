package com.example.insta_test.responses.media;

import com.example.insta_test.models.media.timeline.TimelineMedia;
import com.example.insta_test.responses.IGResponse;

import java.util.List;

import lombok.Data;

@Data
public class MediaInfoResponse extends IGResponse {
    private List<TimelineMedia> items;
    private int num_results;
    private boolean more_available;
}
