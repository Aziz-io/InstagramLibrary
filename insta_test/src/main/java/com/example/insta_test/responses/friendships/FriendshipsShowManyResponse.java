package com.example.insta_test.responses.friendships;

import com.example.insta_test.models.friendships.Friendship;
import com.example.insta_test.responses.IGResponse;

import java.util.Map;

import lombok.Data;

@Data
public class FriendshipsShowManyResponse extends IGResponse {
    private Map<String, Friendship> friendship_statuses;
}
