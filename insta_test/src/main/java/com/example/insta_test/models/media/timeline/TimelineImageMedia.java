package com.example.insta_test.models.media.timeline;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.example.insta_test.models.media.ImageMedia;
import com.example.insta_test.models.media.ImageVersions;
import com.example.insta_test.models.media.ImageVersionsMeta;

import java.util.List;

import lombok.Data;

@Data
@JsonTypeName("1")
public class TimelineImageMedia extends TimelineMedia implements ImageMedia {
    private ImageVersions image_versions2;
    private List<ImageVersionsMeta> candidates;
    private long video_duration;
    private boolean has_audio;
    private int original_width;
    private int original_height;
    private int view_count;

    @Override
    public long getPk() {
        return 0;
    }

    @Override
    public ImageVersions getImage_versions2() {
        return image_versions2;
    }

    @Override
    public List<ImageVersionsMeta> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<ImageVersionsMeta> candidates) {
        this.candidates = candidates;
    }
}