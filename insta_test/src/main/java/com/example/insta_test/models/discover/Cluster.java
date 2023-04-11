package com.example.insta_test.models.discover;

import com.example.insta_test.models.IGBaseModel;

import java.util.List;

import lombok.Data;

@Data
public class Cluster extends IGBaseModel {
    private String id;
    private String title;
    private String context;
    private String description;
    private List<String> labels;
    private String name;
    private String type;
}
