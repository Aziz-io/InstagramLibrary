package com.example.insta_test.requests.media;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.feed.FeedUsersResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MediaGetLikersRequest extends IGGetRequest<FeedUsersResponse> {
    @NonNull
    private String _id;

    @Override
    public String path() {
        return "media/" + _id + "/likers/";
    }

    @Override
    public Class<FeedUsersResponse> getResponseType() {
        return FeedUsersResponse.class;
    }
}
