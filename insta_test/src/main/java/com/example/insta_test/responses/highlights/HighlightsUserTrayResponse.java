package com.example.insta_test.responses.highlights;

import com.example.insta_test.models.highlights.Highlight;
import com.example.insta_test.models.igtv.Channel;
import com.example.insta_test.responses.IGResponse;

import java.util.List;

import lombok.Data;

@Data
public class HighlightsUserTrayResponse extends IGResponse {
    private List<Highlight> tray;
    private Channel tv_channel;
}
