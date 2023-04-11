package com.example.insta_test.requests.media;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.media.MediaPermalinkResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MediaPermalinkRequest extends IGGetRequest<MediaPermalinkResponse> {
    @NonNull
    private String media_id;
    
    @Override
    public String path() {
        return "media/" + media_id + "/permalink/";
    }

    @Override
    public Class<MediaPermalinkResponse> getResponseType() {
        return MediaPermalinkResponse.class;
    }

}
