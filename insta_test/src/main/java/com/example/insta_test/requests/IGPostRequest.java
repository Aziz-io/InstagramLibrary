package com.example.insta_test.requests;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGBaseModel;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.responses.IGResponse;
import com.example.insta_test.utils.IGUtils;

import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

@Slf4j
public abstract class IGPostRequest<T extends IGResponse> extends IGRequest<T> {

    protected abstract IGBaseModel getPayload(IGClient client);

    protected boolean isSigned() {
        return true;
    }

    @Override
    public Request formRequest(IGClient client) {
        Request.Builder req = new Request.Builder().url(this.formUrl(client));
        this.applyHeaders(client, req);
        req.post(this.getRequestBody(client));

        return req.build();
    }

    protected RequestBody getRequestBody(IGClient client) {
        if (getPayload(client) == null) {
            return RequestBody.create("", null);
        }
        String payload = IGUtils.objectToJson(getPayload(client) instanceof IGPayload
                ? client.setIGPayloadDefaults((IGPayload) getPayload(client))
                : getPayload(client));
        log.debug("Payload : {}", payload);
        if (isSigned()) {
            return RequestBody.create(IGUtils.generateSignature(payload),
                    MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8"));
        } else {
            return RequestBody.create(payload, MediaType.parse("application/json; charset=UTF-8"));
        }
    }

}
