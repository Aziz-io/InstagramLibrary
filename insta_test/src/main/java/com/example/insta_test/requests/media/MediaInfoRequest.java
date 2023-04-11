package com.example.insta_test.requests.media;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.media.MediaInfoResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MediaInfoRequest extends IGGetRequest<MediaInfoResponse> {
    @NonNull
    private String id;

    @Override
    public String path() {
        return "media/" + id + "/info/";
    }

    @Override
    public Class<MediaInfoResponse> getResponseType() {
        return MediaInfoResponse.class;
    }

}
