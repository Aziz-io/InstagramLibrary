package com.example.insta_test.models.media.timeline;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.example.insta_test.models.media.ImageVersions;
import com.example.insta_test.models.media.VideoVersionsMeta;

import java.util.List;

import lombok.Data;

@Data
@JsonTypeName("2")
public class VideoCarouselItem extends CarouselItem {
    private ImageVersions image_versions2;
    private List<VideoVersionsMeta> video_versions;

    public ImageVersions getImage_versions2() {
        return image_versions2;
    }

    public void setImage_versions2(ImageVersions image_versions2) {
        this.image_versions2 = image_versions2;
    }

    public List<VideoVersionsMeta> getVideo_versions() {
        return video_versions;
    }

    public void setVideo_versions(List<VideoVersionsMeta> video_versions) {
        this.video_versions = video_versions;
    }
}
