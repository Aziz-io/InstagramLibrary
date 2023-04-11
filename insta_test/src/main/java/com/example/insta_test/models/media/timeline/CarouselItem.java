package com.example.insta_test.models.media.timeline;

import com.example.insta_test.models.media.Media;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;

@Data
@JsonTypeInfo(defaultImpl = CarouselItem.class, use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY, property = "media_type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ImageCarouselItem.class),
        @JsonSubTypes.Type(value = VideoCarouselItem.class)
})
public class CarouselItem extends Media {
    private int original_width;
    private int original_height;
    private String media_type;
    private String carousel_parent_id;


}
