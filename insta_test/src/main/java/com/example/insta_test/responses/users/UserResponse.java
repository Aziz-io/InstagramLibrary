package com.example.insta_test.responses.users;

import com.example.insta_test.models.user.User;
import com.example.insta_test.responses.IGResponse;


import lombok.Data;

@Data
public class UserResponse extends IGResponse {
    private User user;
}
