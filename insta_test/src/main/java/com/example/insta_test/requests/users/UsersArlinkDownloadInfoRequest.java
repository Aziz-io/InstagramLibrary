package com.example.insta_test.requests.users;

import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.IGResponse;

public class UsersArlinkDownloadInfoRequest extends IGGetRequest<IGResponse> {

    @Override
    public String path() {
        return "users/arlink_download_info/?version_override=2.2.1";
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

}
