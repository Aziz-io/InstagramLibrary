package com.example.insta_test.responses.media;

import com.example.insta_test.models.media.timeline.Comment;
import com.example.insta_test.responses.IGResponse;

import lombok.Data;

@Data
public class MediaCommentResponse extends IGResponse {
    private Comment comment;
}
