package com.example.insta_test.requests.igtv;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.requests.IGPaginatedRequest;
import com.example.insta_test.responses.igtv.IgtvBrowseFeedResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class IgtvBrowseFeedRequest extends IGGetRequest<IgtvBrowseFeedResponse>
        implements IGPaginatedRequest {
    @Setter
    private String max_id;
    @Setter
    private long min_timestamp;

    @Override
    public String path() {
        return "igtv/browse_feed/";
    }

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("max_id", max_id);
    }

    @Override
    public Class<IgtvBrowseFeedResponse> getResponseType() {
        return IgtvBrowseFeedResponse.class;
    }



    public IGPayload getPayload(IGClient client) {
        IgtvBrowseFeedPayload payload = new IgtvBrowseFeedPayload();
        if (!max_id.isEmpty()) {
            payload.setMax_id(max_id);
            payload.setReason("pagination");
        }
        if (min_timestamp > 0) {
            payload.setMin_timestamp(min_timestamp);
        }
        return payload;
    }

    @Data
    public static class IgtvBrowseFeedPayload extends IGPayload {
        private String max_id;
        private String reason = "cold_start_fetch";
        private long min_timestamp;



        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public long getMin_timestamp() {
            return min_timestamp;
        }

        public void setMin_timestamp(long min_timestamp) {
            this.min_timestamp = min_timestamp;
        }
    }
}