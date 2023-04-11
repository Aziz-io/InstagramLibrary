package com.example.insta_test.models.highlights;

import com.example.insta_test.models.IGBaseModel;
import com.example.insta_test.models.user.Profile;

import lombok.Data;

@Data
public class Highlight extends IGBaseModel {
    private String id;
    private long latest_reel_media;
    private Profile user;
    private String title;
    private int media_count;
}
