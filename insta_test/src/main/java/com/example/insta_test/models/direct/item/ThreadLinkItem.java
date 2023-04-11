package com.example.insta_test.models.direct.item;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.example.insta_test.models.media.Link;

import lombok.Data;

@Data
@JsonTypeName("link")
public class ThreadLinkItem extends ThreadItem {
    private Link link;
}
