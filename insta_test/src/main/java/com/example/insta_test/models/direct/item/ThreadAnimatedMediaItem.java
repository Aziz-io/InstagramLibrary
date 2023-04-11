package com.example.insta_test.models.direct.item;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.example.insta_test.models.media.thread.ThreadAnimatedMedia;

import lombok.Data;

@Data
@JsonTypeName("animated_media")
public class ThreadAnimatedMediaItem extends ThreadItem {
    private ThreadAnimatedMedia media;
}
