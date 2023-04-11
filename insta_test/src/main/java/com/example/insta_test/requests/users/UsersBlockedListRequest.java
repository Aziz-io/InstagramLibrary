package com.example.insta_test.requests.users;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.users.UsersBlockedListResponse;

public class UsersBlockedListRequest extends IGGetRequest<UsersBlockedListResponse> {

	@Override
    public String path() {
        return "users/blocked_list/";
    }

	@Override
	public Class<UsersBlockedListResponse> getResponseType() {
		return UsersBlockedListResponse.class;
	}

}
