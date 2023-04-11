package com.example.insta_test.responses.friendships;

import com.example.insta_test.models.friendships.Friendship;
import com.example.insta_test.responses.IGResponse;

import lombok.Data;

@Data
public class FriendshipStatusResponse extends IGResponse {
    private Friendship friendship_status;
}
