package com.example.insta_test.models.media.thread;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.example.insta_test.models.media.ImageVersions;

import lombok.Data;

@Data
@JsonTypeName("1")
public class ThreadImageMedia extends ThreadMedia {
    private ImageVersions image_versions2;
}
