package com.example.insta_test.responses.users;

import com.example.insta_test.models.friendships.Friendship;
import com.example.insta_test.models.user.Profile;
import com.example.insta_test.responses.IGResponse;
import java.util.List;

import lombok.Data;

@Data
public class UsersSearchResponse extends IGResponse {

    private int num_results;
    private List<User> users;
    private boolean has_more;
    private String rank_token;
    private String page_token;

    @Data
    public static class User extends Profile {
        Friendship friendship_status;
        String social_context;
        String search_social_context;
        int mutual_followers_count;
        int latest_reel_media;
    }

}
