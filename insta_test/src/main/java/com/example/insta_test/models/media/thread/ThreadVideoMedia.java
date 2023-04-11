package com.example.insta_test.models.media.thread;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.example.insta_test.models.media.ImageVersions;
import com.example.insta_test.models.media.VideoVersionsMeta;

import java.util.List;

import lombok.Data;

@Data
@JsonTypeName("2")
public class ThreadVideoMedia extends ThreadMedia {
    private ImageVersions image_versions2;
    private List<VideoVersionsMeta> video_versions;
}
