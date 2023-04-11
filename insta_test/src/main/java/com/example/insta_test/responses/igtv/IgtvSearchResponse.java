package com.example.insta_test.responses.igtv;

import com.example.insta_test.models.igtv.Channel;
import com.example.insta_test.models.user.User;
import com.example.insta_test.responses.IGResponse;

import java.util.List;

import lombok.Data;

@Data
public class IgtvSearchResponse extends IGResponse {
    private List<IgtvSearchResult> results;
    private int num_results;
    private boolean has_more;
    private String rank_token;

    @Data
    public static class IgtvSearchResult {
        private String type;
        private User user;
        private Channel channel;
    }
}
