package com.example.insta_test.models.music;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.util.StdConverter;
import com.example.insta_test.models.IGBaseModel;
import com.example.insta_test.utils.IGUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class MusicPlaylist extends IGBaseModel {
    private String id;
    private String title;
    private String icon_url;
    @JsonDeserialize(converter = BeanToTrackConverter.class)
    private List<MusicTrack> preview_items;

    public static class BeanToTrackConverter
            extends StdConverter<List<Map<String, Object>>, List<MusicTrack>> {
        @Override
        public List<MusicTrack> convert(List<Map<String, Object>> value) {
            return value.stream()
                    .filter(m -> m.containsKey("track"))
                    .map(m -> IGUtils.convertToView(m.get("track"), MusicTrack.class))
                    .collect(Collectors.toList());
        }
    }
}
