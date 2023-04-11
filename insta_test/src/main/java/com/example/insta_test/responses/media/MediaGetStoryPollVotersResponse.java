package com.example.insta_test.responses.media;

import com.example.insta_test.models.media.reel.VoterInfo;
import com.example.insta_test.responses.IGPaginatedResponse;
import com.example.insta_test.responses.IGResponse;

import lombok.Data;

@Data
public class MediaGetStoryPollVotersResponse extends IGResponse implements IGPaginatedResponse {
    private VoterInfo voter_info;

    @Override
    public String getNext_max_id() {
        return voter_info.getMax_id();
    }

    @Override
    public boolean isMore_available() {
        return voter_info.isMore_available();
    }

}
