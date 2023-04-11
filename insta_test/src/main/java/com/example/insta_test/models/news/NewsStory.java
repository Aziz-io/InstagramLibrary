package com.example.insta_test.models.news;

import com.example.insta_test.models.IGBaseModel;

import lombok.Data;

@Data
public class NewsStory extends IGBaseModel {
    private int type;
    private int story_type;
    private String pk;
}
