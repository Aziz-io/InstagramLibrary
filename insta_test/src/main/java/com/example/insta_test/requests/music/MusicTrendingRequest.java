package com.example.insta_test.requests.music;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.requests.music.MusicSearchRequest.MusicQueryPayload;
import com.example.insta_test.responses.music.MusicTrackResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class MusicTrendingRequest extends IGPostRequest<MusicTrackResponse> {
    private String _cursor = "0";

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new MusicQueryPayload(client.getSessionId(), _cursor);
    }

    @Override
    public String path() {
        return "music/trending/";
    }

    @Override
    public Class<MusicTrackResponse> getResponseType() {
        return MusicTrackResponse.class;
    }

}
