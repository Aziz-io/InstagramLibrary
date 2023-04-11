package com.example.insta_test.requests.archive;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.IGResponse;

public class ArchiveReelRequest extends IGGetRequest<IGResponse> {

    @Override
    public String path() {
        return "archive/reel/day_shells/";
    }

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("include_suggested_highlights", "false",
                "include_cover", "0",
                "is_in_archive_home", "false",
                "timezone_offset", "0");
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

}
