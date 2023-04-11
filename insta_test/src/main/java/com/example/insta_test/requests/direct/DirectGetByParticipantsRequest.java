package com.example.insta_test.requests.direct;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.direct.DirectThreadsResponse;
import com.example.insta_test.utils.IGUtils;

public class DirectGetByParticipantsRequest extends IGGetRequest<DirectThreadsResponse> {
    private Long[] _participants;

    public DirectGetByParticipantsRequest(Long... participants) {
        this._participants = participants;
    }

    @Override
    public String path() {
        return "direct_v2/threads/get_by_participants/";
    }

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("recipient_users", IGUtils.objectToJson(_participants));
    }

    @Override
    public Class<DirectThreadsResponse> getResponseType() {
        return DirectThreadsResponse.class;
    }

}
