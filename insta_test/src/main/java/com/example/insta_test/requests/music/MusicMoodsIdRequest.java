package com.example.insta_test.requests.music;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.requests.music.MusicSearchRequest.MusicQueryPayload;
import com.example.insta_test.responses.music.MusicTrackResponse;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class MusicMoodsIdRequest extends IGPostRequest<MusicTrackResponse> {
    @NonNull
    private String _id;
    private String _cursor = "0";

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new MusicQueryPayload(client.getSessionId(), _cursor);
    }

    @Override
    public String path() {
        return "music/moods/" + _id + "/";
    }

    @Override
    public Class<MusicTrackResponse> getResponseType() {
        return MusicTrackResponse.class;
    }

}
