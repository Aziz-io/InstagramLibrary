package com.example.insta_test.models.media;

import java.util.List;

import lombok.Data;

@Data
public class ImageVersions {
    private List<ImageVersionsMeta> candidates;
}
