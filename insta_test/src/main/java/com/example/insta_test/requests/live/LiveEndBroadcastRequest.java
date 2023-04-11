package com.example.insta_test.requests.live;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.IGResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class LiveEndBroadcastRequest extends IGPostRequest<IGResponse> {
    @NonNull
    private String broadcastId;
    private boolean endAfterCopyrightWarning;

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new IGPayload() {
            @Getter
            private boolean end_after_copyright_warning = endAfterCopyrightWarning;
        };
    }

    @Override
    public String path() {
        return "live/" + broadcastId + "/end_broadcast/";
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

}
