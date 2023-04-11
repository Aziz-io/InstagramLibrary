package com.example.insta_test.models.media;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Viewer {
    private long pk;
    private String username;
    private String full_name;
    @JsonProperty("is_private")
    private boolean is_private;
    private String profile_pic_url;
    private String profile_pic_id;
    @JsonProperty("is_verified")
    private boolean is_verified;
}
