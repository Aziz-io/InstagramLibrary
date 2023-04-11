package com.example.insta_test.models.media.reel;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.example.insta_test.models.media.ImageVersions;
import com.example.insta_test.models.media.VideoVersionsMeta;

import java.util.List;

import lombok.Data;

@Data
@JsonTypeName("2")
public class ReelVideoMedia extends ReelMedia {
    private boolean has_audio;
    private int number_of_qualities;
    private double video_duration;
    private ImageVersions image_versions2;
    private List<VideoVersionsMeta> video_versions;
}
