package com.example.insta_test.models.direct.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.util.StdConverter;
import com.example.insta_test.models.media.Media;
import com.example.insta_test.utils.IGUtils;

import java.util.Map;

import lombok.Data;

@Data
@JsonTypeName("clip")
public class ThreadClipItem extends ThreadItem{
    @JsonProperty("clip")
    @JsonDeserialize(converter = ClipToMedia.class)
    private Media media;

    private static class ClipToMedia
            extends StdConverter<Map<String, Object>, Media> {
        @Override
        public Media convert(Map<String, Object> value) {
            return IGUtils.convertToView(value.get("clip"), Media.class);
        }
    }
}
