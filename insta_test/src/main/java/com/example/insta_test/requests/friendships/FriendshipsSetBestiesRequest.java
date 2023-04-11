package com.example.insta_test.requests.friendships;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.friendships.FriendshipStatusResponse;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FriendshipsSetBestiesRequest extends IGPostRequest<FriendshipStatusResponse> {
    private final Long[] _add, _remove;

    public FriendshipsSetBestiesRequest(boolean add, Long... pks) {
        this._add = add ? pks : null;
        this._remove = !add ? pks : null;
    }

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new FriendshipsSetBestiesPayload();
    }

    @Override
    public String path() {
        return "friendships/set_besties/";
    }

    @Override
    public Class<FriendshipStatusResponse> getResponseType() {
        return FriendshipStatusResponse.class;
    }

    @Data
    @JsonInclude(Include.NON_NULL)
    public class FriendshipsSetBestiesPayload extends IGPayload {
        private Long[] add = _add;
        private Long[] remove = _remove;
    }

}
