package com.example.insta_test.models.media;

import com.example.insta_test.models.IGBaseModel;
import com.example.insta_test.models.user.Profile;

import java.util.List;

import lombok.Data;

@Data
public class UserTags extends IGBaseModel {
    private List<UserTag> in;

    @Data
    public static class UserTag {
        private Profile user;
        private double[] position;
        private long start_time_in_video_sec;
        private long duration_in_video_in_sec;
    }

    @Data
    public static class UserTagPayload {
        private final long user_id;
        private final double[] position;

        public UserTagPayload(long pk, double x, double y) {
            this.user_id = pk;
            position = new double[] {x, y};
        }
    }
}
