package com.example.insta_test.responses.media;


import com.example.insta_test.models.media.reel.ResponderInfo;
import com.example.insta_test.responses.IGPaginatedResponse;
import com.example.insta_test.responses.IGResponse;

import lombok.Data;

@Data
public class MediaGetStoryQuestionResponsesResponse extends IGResponse implements IGPaginatedResponse {
    private ResponderInfo responder_info;

    @Override
    public String getNext_max_id() {
        return this.responder_info.getMax_id();
    }

    @Override
    public boolean isMore_available() {
        return this.responder_info.isMore_available();
    }
}
