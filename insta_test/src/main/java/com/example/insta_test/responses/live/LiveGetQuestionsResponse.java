package com.example.insta_test.responses.live;

import com.example.insta_test.models.user.Profile;
import com.example.insta_test.responses.IGResponse;

import java.util.List;

import lombok.Data;

@Data
public class LiveGetQuestionsResponse extends IGResponse {
    private List<LiveQuestions> questions;

    @Data
    public static class LiveQuestions {
        private String text;
        private long qid;
        private String source;
        private Profile user;
        private long timestamp;
    }
}
