package com.example.insta_test.models.direct;

import com.example.insta_test.models.direct.item.ThreadRavenMediaItem;

import java.util.List;

import lombok.Data;

@Data
public class DirectStory {
    private List<ThreadRavenMediaItem> items;
    private long last_activity_at;
    private boolean has_newer;
    private String next_cursor;
}
