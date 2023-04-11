package com.example.insta_test.models.direct.item;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.example.insta_test.models.media.thread.ThreadMedia;

import java.util.List;

import lombok.Data;

@Data
@JsonTypeName("raven_media")
public class ThreadRavenMediaItem extends ThreadItem {
    private ThreadVisualMedia visual_media;

    @Data
    public static class ThreadVisualMedia {
        private long url_expire_at_secs;
        private int playback_duration_secs;
        private ThreadMedia media;
        private List<String> seen_user_ids;
        private String view_mode;
        private int seen_count;
    }
}
