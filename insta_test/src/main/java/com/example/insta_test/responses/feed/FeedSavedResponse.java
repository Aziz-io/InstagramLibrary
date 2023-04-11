package com.example.insta_test.responses.feed;

import com.example.insta_test.models.media.timeline.TimelineMedia;
import com.example.insta_test.responses.IGPaginatedResponse;
import com.example.insta_test.responses.IGResponse;
import com.example.insta_test.utils.IGUtils;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.util.StdConverter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class FeedSavedResponse extends IGResponse implements IGPaginatedResponse {
    @JsonDeserialize(converter = MediaBeanToIGTimelineMedia.class)
    private List<TimelineMedia> items;
    private String next_max_id;
    private boolean more_available;

    private static class MediaBeanToIGTimelineMedia
            extends StdConverter<List<Map<String, Object>>, List<TimelineMedia>> {
        @Override
        public List<TimelineMedia> convert(List<Map<String, Object>> value) {
            return value.stream()
                    .filter(m -> m.containsKey("media"))
                    .map(m -> IGUtils.convertToView(m.get("media"), TimelineMedia.class))
                    .collect(Collectors.toList());
        }
    }
}
