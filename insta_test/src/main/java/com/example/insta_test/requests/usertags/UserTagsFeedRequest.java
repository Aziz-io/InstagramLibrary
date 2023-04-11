package com.example.insta_test.requests.usertags;


import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.requests.IGPaginatedRequest;
import com.example.insta_test.responses.usertags.UserTagsFeedResponse;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
public class UserTagsFeedRequest extends IGGetRequest<UserTagsFeedResponse>
					implements IGPaginatedRequest {
	
    private long userId;
    
    @Setter 
    private String max_id;
    
    @Override
    public String path() {
        return "usertags/"+userId+"/feed/";
    }

    @Override
    public Class<UserTagsFeedResponse> getResponseType() {
        return UserTagsFeedResponse.class;
    }

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("max_id", max_id);
    }
}
