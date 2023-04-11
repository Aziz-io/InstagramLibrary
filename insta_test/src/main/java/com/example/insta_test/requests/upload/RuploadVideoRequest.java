package com.example.insta_test.requests.upload;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGBaseModel;
import com.example.insta_test.models.media.UploadParameters;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.IGResponse;
import com.example.insta_test.utils.IGUtils;

import java.util.concurrent.ThreadLocalRandom;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class RuploadVideoRequest extends IGPostRequest<IGResponse> {

    private final byte[] videoData;
    private final UploadParameters upload_params;
    private final String name;

    public RuploadVideoRequest(final byte data[], final UploadParameters param) {
        this.videoData = data;
        this.upload_params = param;
        this.name = upload_params.getUpload_id() + "_0_" + ThreadLocalRandom.current().nextLong(1_000_000_000, 9_999_999_999l);
    }

    @Override
    protected IGBaseModel getPayload(IGClient client) {
        return null;
    }

    @Override
    public String apiPath() {
        return "";
    }

    @Override
    public String path() {
        return "rupload_igvideo/" + name;
    }

    @Override
    public Request.Builder applyHeaders(IGClient client, Request.Builder req) {
        super.applyHeaders(client, req);
        req.addHeader("X-Instagram-Rupload-Params", IGUtils.objectToJson(upload_params));
        req.addHeader("X_FB_VIDEO_WATERFALL_ID", IGUtils.randomUuid());
        req.addHeader("X-Entity-Type", "video/mp4");
        req.addHeader("Offset", "0");
        req.addHeader("X-Entity-Name", name);
        req.addHeader("X-Entity-Length", String.valueOf(videoData.length));

        return req;
    }

    @Override
    public RequestBody getRequestBody(IGClient client) {
        return RequestBody.create(videoData, MediaType.get("application/octet-stream"));
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }

}
