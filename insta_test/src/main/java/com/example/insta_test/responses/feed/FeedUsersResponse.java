package com.example.insta_test.responses.feed;

import com.example.insta_test.models.user.Profile;
import com.example.insta_test.responses.IGPaginatedResponse;
import com.example.insta_test.responses.IGResponse;

import java.util.List;

import lombok.Data;

@Data
public class FeedUsersResponse extends IGResponse implements IGPaginatedResponse {
    private List<Profile> users;
    private String next_max_id;

    public boolean isMore_available() {
        return next_max_id != null;
    }
}
