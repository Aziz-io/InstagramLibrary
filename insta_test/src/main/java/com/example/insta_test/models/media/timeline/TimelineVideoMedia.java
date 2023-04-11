package com.example.insta_test.models.media.timeline;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.example.insta_test.models.media.ImageVersions;
import com.example.insta_test.models.media.VideoVersionsMeta;

import java.util.List;

import lombok.Data;

// media_type 2
@Data
@JsonTypeName("2")
public class TimelineVideoMedia extends TimelineMedia {
    private List<VideoVersionsMeta> video_versions;
    private ImageVersions image_versions2;
    private long video_duration;
    private boolean has_audio;
    private int original_width;
    private int original_height;
    private int view_count;
}
