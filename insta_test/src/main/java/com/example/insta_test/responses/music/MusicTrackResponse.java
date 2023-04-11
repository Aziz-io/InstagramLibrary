package com.example.insta_test.responses.music;

import com.example.insta_test.models.music.MusicPlaylist;
import com.example.insta_test.models.music.MusicTrack;
import com.example.insta_test.responses.IGPaginatedResponse;
import com.example.insta_test.responses.IGResponse;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

import lombok.Data;

@Data
public class MusicTrackResponse extends IGResponse implements IGPaginatedResponse {
    @JsonDeserialize(converter = MusicPlaylist.BeanToTrackConverter.class)
    private List<MusicTrack> items;
    private MusicTrackPageInfo page_info;

    public String getNext_max_id() {
        return page_info.getNext_max_id();
    }

    public boolean isMore_available() {
        return page_info.isMore_available();
    }

    @Data
    public static class MusicTrackPageInfo {
        private String next_max_id;
        private boolean more_available;
    }
}
