package com.example.insta_test.requests.media;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.requests.IGPaginatedRequest;
import com.example.insta_test.responses.feed.FeedUsersResponse;
import com.example.insta_test.responses.igtv.IgtvBrowseFeedResponse;
import com.example.insta_test.responses.media.MediaGetCommentsResponse;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
public class MediaGetCommentsRequest extends IGGetRequest<MediaGetCommentsResponse>
        implements IGPaginatedRequest {
    private final String mediaId;
    private String maxId;

    public MediaGetCommentsRequest(@NonNull String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String path() {
        return null;
    }

    @Override
    public Class<MediaGetCommentsResponse> getResponseType() {
        return null;
    }

    @Override
    public void setMax_id(String s) {

    }

    // rest of the class implementation
}