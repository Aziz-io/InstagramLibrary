package com.example.insta_test.requests.feed;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPaginatedRequest;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.feed.FeedTimelineResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class FeedTimelineRequest extends IGPostRequest<FeedTimelineResponse>
        implements IGPaginatedRequest {
    @Setter
    private String max_id = "";
    @Setter
    private int count = 12; // set the default count to 12 or any other value you prefer

    public String getMax_id() {
        return max_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public IGPayload getPayload(IGClient client) {
        FeedTimelinePayload payload = new FeedTimelinePayload();
        if (!max_id.isEmpty()) {
            payload.setMax_id(max_id);
            payload.setReason("pagination");
        }
        payload.setCount(count); // set the count parameter
        return payload;
    }

    @Override
    public String path() {
        return "feed/timeline/";
    }

    @Override
    public Class<FeedTimelineResponse> getResponseType() {
        return FeedTimelineResponse.class;
    }

    @Override
    public void setMax_id(String s) {
        this.max_id = s;
    }

    @Data
    @JsonInclude(Include.NON_NULL)
    public static class FeedTimelinePayload extends IGPayload {
        private String max_id;
        private String reason = "cold_start_fetch";
        private String is_pull_to_refresh = "0";
        private String is_prefetch = "0";
        private int count; // add the count parameter


        public String getMax_id() {
            return max_id;
        }

        public void setMax_id(String max_id) {
            this.max_id = max_id;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getIs_pull_to_refresh() {
            return is_pull_to_refresh;
        }

        public void setIs_pull_to_refresh(String is_pull_to_refresh) {
            this.is_pull_to_refresh = is_pull_to_refresh;
        }

        public String getIs_prefetch() {
            return is_prefetch;
        }

        public void setIs_prefetch(String is_prefetch) {
            this.is_prefetch = is_prefetch;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}