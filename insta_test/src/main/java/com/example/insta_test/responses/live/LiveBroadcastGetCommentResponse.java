package com.example.insta_test.responses.live;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.insta_test.models.media.timeline.Comment;
import com.example.insta_test.models.media.timeline.Comment.Caption;
import com.example.insta_test.responses.IGResponse;

import java.util.List;

import lombok.Data;

@Data
public class LiveBroadcastGetCommentResponse extends IGResponse {
    private boolean comment_likes_enabled;
    private List<Comment> comments;
    private int comment_count;
    private Caption caption;
    @JsonProperty("is_first_fetch")
    private boolean is_first_fetch;
}
