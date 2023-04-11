package com.example.insta_test.requests.launcher;

import com.example.insta_test.IGClient;
import com.example.insta_test.IGConstants;
import com.example.insta_test.models.IGBaseModel;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.IGResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class LauncherSyncRequest extends IGPostRequest<IGResponse> {
    private boolean preLogin;

    @Override
    public String baseApiUrl() {
        return preLogin ? IGConstants.B_BASE_API_URL : super.baseApiUrl();
    }

    @Override
    protected IGBaseModel getPayload(IGClient client) {
        return preLogin ? new PrePayload(client.getPhoneId()) : new PostPayload();
    }

    @Override
    public String path() {
        return "launcher/sync/";
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

    @Data
    private class PrePayload extends IGBaseModel {
        private final String id;
        private final String server_config_retrieval = "1";
    }

    @Data
    private class PostPayload extends IGPayload {
        private final String server_config_retrieval = "1";
    }

}
