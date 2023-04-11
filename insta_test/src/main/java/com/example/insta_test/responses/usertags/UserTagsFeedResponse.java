package com.example.insta_test.responses.usertags;

import com.example.insta_test.models.media.timeline.TimelineMedia;
import com.example.insta_test.responses.IGPaginatedResponse;
import com.example.insta_test.responses.IGResponse;

import java.util.List;

import lombok.Data;

@Data
public class UserTagsFeedResponse extends IGResponse implements IGPaginatedResponse {

	private List<TimelineMedia> items;
	
	private int num_results;
	private String next_max_id;
	private boolean more_available;
	
	
}
