package com.example.insta_test.models.media.reel;

import com.example.insta_test.models.IGBaseModel;
import com.example.insta_test.models.user.Profile;

import java.util.List;

import lombok.Data;

@Data
public class VoterInfo extends IGBaseModel {
    private Long poll_id;
    private List<Voter> voters;
    private String max_id;
    private boolean more_available;

    @Data
    public static class Voter {
        private Profile user;
        private int vote;
        private Long ts;
    }
}
