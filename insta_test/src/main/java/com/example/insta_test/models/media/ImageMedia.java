package com.example.insta_test.models.media;

import com.example.insta_test.models.media.timeline.Comment.Caption;
import com.example.insta_test.models.user.User;

import java.util.List;


public interface ImageMedia {
    long getPk();

    String getId();

    long getTaken_at();

    long getDevice_timestamp();

    String getMedia_type();

    String getCode();

    String getClient_cache_key();

    int getFilter_type();

    User getUser();

    Caption getCaption();

    ImageVersions getImage_versions2();

    List<ImageVersionsMeta> getCandidates();
}
