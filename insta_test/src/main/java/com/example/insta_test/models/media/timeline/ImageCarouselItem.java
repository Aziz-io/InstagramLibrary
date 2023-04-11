package com.example.insta_test.models.media.timeline;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.example.insta_test.models.media.ImageVersions;

import lombok.Data;

// media_type 1
@Data
@JsonTypeName("1")
public class ImageCarouselItem extends CarouselItem {
    private ImageVersions image_versions2;

    public ImageVersions getImage_versions2() {
        return image_versions2;
    }

    public void setImage_versions2(ImageVersions image_versions2) {
        this.image_versions2 = image_versions2;
    }
}
