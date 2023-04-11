package com.example.insta_test.models.direct.item;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.example.insta_test.models.media.VoiceMedia;

import lombok.Data;

@Data
@JsonTypeName("voice_media")
public class ThreadVoiceMediaItem extends ThreadItem {
    private VoiceMedia media;
}
