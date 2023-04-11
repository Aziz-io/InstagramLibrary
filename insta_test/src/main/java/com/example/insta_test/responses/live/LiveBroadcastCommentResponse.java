package com.example.insta_test.responses.live;

import com.example.insta_test.models.media.timeline.Comment;
import com.example.insta_test.responses.IGResponse;

import lombok.Data;

@Data
public class LiveBroadcastCommentResponse extends IGResponse {
    private Comment comment;
}
