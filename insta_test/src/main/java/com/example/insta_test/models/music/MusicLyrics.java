package com.example.insta_test.models.music;

import com.example.insta_test.models.IGBaseModel;

import java.util.List;

import lombok.Data;

@Data
public class MusicLyrics {
    private List<LyricPhrase> phrases;

    @Data
    public static class LyricPhrase extends IGBaseModel {
        private long start_time_in_ms;
        private long end_time_in_ms;
        private String phrase;
    }
}
