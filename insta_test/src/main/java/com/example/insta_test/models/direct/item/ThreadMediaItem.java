package com.example.insta_test.models.direct.item;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.example.insta_test.models.media.thread.ThreadMedia;

import lombok.Data;

@Data
@JsonTypeName("media")
public class ThreadMediaItem extends ThreadItem {
    private ThreadMedia media;
}
