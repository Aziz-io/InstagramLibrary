package com.example.insta_test.models.media.reel;

import com.example.insta_test.models.media.ImageVersionsMeta;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.example.insta_test.models.media.ImageMedia;
import com.example.insta_test.models.media.ImageVersions;

import java.util.List;

import lombok.Data;

@Data
@JsonTypeName("1")
public class ReelImageMedia extends ReelMedia implements ImageMedia {
    private ImageVersions image_versions2;

    @Override
    public long getPk() {
        return 0;
    }

    @Override
    public ImageVersions getImage_versions2() {
        return null;
    }

    @Override
    public List<ImageVersionsMeta> getCandidates() {
        return null;
    }
}
