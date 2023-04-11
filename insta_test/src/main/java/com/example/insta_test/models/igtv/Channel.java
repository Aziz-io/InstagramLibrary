package com.example.insta_test.models.igtv;

import com.example.insta_test.models.IGBaseModel;
import com.example.insta_test.models.media.timeline.TimelineVideoMedia;
import com.example.insta_test.models.user.User;

import java.util.List;

import lombok.Data;

@Data
public class Channel extends IGBaseModel {
    private String id;
    private List<TimelineVideoMedia> items;
    private boolean more_available;
    private String title;
    private String type;
    private String max_id;
    private User user_dict;
    private String description;
    private String cover_photo_url;
}
