package com.example.insta_test.responses.friendships;

import com.example.insta_test.models.friendships.Friendship;
import com.example.insta_test.responses.IGResponse;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Data;

@Data
public class FriendshipsShowResponse extends IGResponse {
    @JsonUnwrapped
    private Friendship friendship;
}
