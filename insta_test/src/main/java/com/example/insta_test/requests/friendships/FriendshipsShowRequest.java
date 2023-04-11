package com.example.insta_test.requests.friendships;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.friendships.FriendshipsShowResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FriendshipsShowRequest extends IGGetRequest<FriendshipsShowResponse> {
    @NonNull
    private Long pk;

    @Override
    public String path() {
        return "friendships/show/" + pk + "/";
    }

    @Override
    public Class<FriendshipsShowResponse> getResponseType() {
        return FriendshipsShowResponse.class;
    }

}
