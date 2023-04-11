package com.example.insta_test.models.media.reel;

import com.example.insta_test.models.IGBaseModel;
import com.example.insta_test.models.user.Profile;

import java.util.List;

import lombok.Data;

@Data
public class ResponderInfo extends IGBaseModel {
    private Long question_id;
    private String question;
    private String question_type;
    private List<Responder> responders;
    private String max_id;
    private boolean more_available;

    @Data
    public static class Responder {
        private Profile user;
        private String response;
        private String id;
        private Long ts;
    }
}
