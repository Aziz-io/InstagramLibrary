package com.example.insta_test.responses.live;

import com.example.insta_test.models.user.Profile;
import com.example.insta_test.responses.IGResponse;

import java.util.List;

import lombok.Data;

@Data
public class LiveBroadcastGetViewerListResponse extends IGResponse {
    private List<Profile> users;
}
