package com.example.insta_test.models.direct.item;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.example.insta_test.models.media.Media;

import lombok.Data;

@Data
@JsonTypeName("media_share")
public class ThreadMediaShareItem extends ThreadItem {
    private Media media_share;
}
