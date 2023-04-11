package com.example.insta_test.models.direct.item;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.example.insta_test.models.media.timeline.TimelineMedia;
import com.example.insta_test.models.user.Profile;

import java.util.List;

import lombok.Data;

@Data
@JsonTypeName("profile")
public class ThreadProfileItem extends ThreadItem {
    private Profile profile;
    private List<TimelineMedia> preview_medias;
}
