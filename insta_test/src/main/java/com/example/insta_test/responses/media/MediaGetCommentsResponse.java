package com.example.insta_test.responses.media;

import com.example.insta_test.models.media.timeline.Comment;
import com.example.insta_test.responses.IGPaginatedResponse;
import com.example.insta_test.responses.IGResponse;

import java.util.List;

import lombok.Data;

@Data
public class MediaGetCommentsResponse extends IGResponse implements IGPaginatedResponse {
    private List<Comment> comments;
    private Comment.Caption caption;
    private String next_max_id;

    public boolean isMore_available() {
        return next_max_id != null;
    }
}
