package com.example.insta_test.requests.upload;

import androidx.annotation.NonNull;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.IGResponse;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class MediaUploadFinishRequest extends IGPostRequest<IGResponse> {
    @NonNull
    private String uploadId;


    @NonNull
    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(@NonNull String uploadId) {
        this.uploadId = uploadId;
    }

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new MediaUploadFinishPayload();
    }

    @Override
    public String path() {
        return "media/upload_finish/";
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }




    public class MediaUploadFinishPayload extends IGPayload {
        private String upload_id = uploadId;

        public MediaUploadFinishPayload() {
        }

        public MediaUploadFinishPayload(String upload_id) {
            this.upload_id = upload_id;
        }

        public String getUpload_id() {
            return upload_id;
        }

        public void setUpload_id(String upload_id) {
            this.upload_id = upload_id;
        }
    }
}
