package com.example.insta_test.responses.media;

import com.example.insta_test.models.media.reel.ReelMedia;
import com.example.insta_test.models.user.Profile;
import com.example.insta_test.responses.IGPaginatedResponse;
import com.example.insta_test.responses.IGResponse;

import java.util.List;

import lombok.Data;

@Data
public class MediaListReelMediaViewerResponse extends IGResponse implements IGPaginatedResponse {
    private List<Profile> users;
    private String next_max_id;
    private int user_count;
    private int total_viewer_count;
    private ReelMedia updated_media;

    public boolean isMore_available() {
        return next_max_id != null;
    }
}
