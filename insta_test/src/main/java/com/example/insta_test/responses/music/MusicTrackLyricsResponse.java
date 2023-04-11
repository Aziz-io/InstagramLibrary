package com.example.insta_test.responses.music;

import com.example.insta_test.models.music.MusicLyrics;
import com.example.insta_test.responses.IGResponse;
import lombok.Data;

@Data
public class MusicTrackLyricsResponse extends IGResponse {
    private MusicLyrics lyrics;
}
