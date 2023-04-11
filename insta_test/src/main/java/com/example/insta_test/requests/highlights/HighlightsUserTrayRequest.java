package com.example.insta_test.requests.highlights;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.highlights.HighlightsUserTrayResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HighlightsUserTrayRequest extends IGGetRequest<HighlightsUserTrayResponse> {
    @NonNull
    private Long pk;

    @Override
    public String path() {
        return "highlights/" + pk + "/highlights_tray/";
    }

    @Override
    public Class<HighlightsUserTrayResponse> getResponseType() {
        return HighlightsUserTrayResponse.class;
    }

}
