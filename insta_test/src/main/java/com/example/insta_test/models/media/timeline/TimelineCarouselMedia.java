package com.example.insta_test.models.media.timeline;

import com.example.insta_test.models.media.ImageMedia;
import com.example.insta_test.models.media.ImageVersions;
import com.example.insta_test.models.media.ImageVersionsMeta;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

import lombok.Data;

@Data
@JsonTypeName("8")
public class TimelineCarouselMedia extends TimelineMedia implements ImageMedia {
    private int carousel_media_count;
    private List<CarouselItem> carousel_media;
    private ImageVersions image_versions2;
    private List<ImageVersionsMeta> candidates;
    private long video_duration;
    private boolean has_audio;
    private int original_width;
    private int original_height;
    private int view_count;

    public int getCarousel_media_count() {
        return carousel_media_count;
    }

    public void setCarousel_media_count(int carousel_media_count) {
        this.carousel_media_count = carousel_media_count;
    }

    public List<CarouselItem> getCarousel_media() {
        return carousel_media;
    }

    public void setCarousel_media(List<CarouselItem> carousel_media) {
        this.carousel_media = carousel_media;
    }

    public void setImage_versions2(ImageVersions image_versions2) {
        this.image_versions2 = image_versions2;
    }

    public long getVideo_duration() {
        return video_duration;
    }

    public void setVideo_duration(long video_duration) {
        this.video_duration = video_duration;
    }

    public boolean isHas_audio() {
        return has_audio;
    }

    public void setHas_audio(boolean has_audio) {
        this.has_audio = has_audio;
    }

    public int getOriginal_width() {
        return original_width;
    }

    public void setOriginal_width(int original_width) {
        this.original_width = original_width;
    }

    public int getOriginal_height() {
        return original_height;
    }

    public void setOriginal_height(int original_height) {
        this.original_height = original_height;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

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