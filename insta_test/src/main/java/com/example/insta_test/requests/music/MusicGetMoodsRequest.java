package com.example.insta_test.requests.music;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.music.MusicGetResponse;

public class MusicGetMoodsRequest extends IGPostRequest<MusicGetResponse> {

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new IGPayload();
    }

    @Override
    public String path() {
        return "music/moods/";
    }

    @Override
    public Class<MusicGetResponse> getResponseType() {
        return MusicGetResponse.class;
    }

}
