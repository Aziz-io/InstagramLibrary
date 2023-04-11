package com.example.insta_test.responses.direct;

import com.example.insta_test.responses.IGResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;


public class DirectGetPresenceResponse extends IGResponse {
    private Map<Long, UserPresence> user_presence;

    public DirectGetPresenceResponse(Map<Long, UserPresence> user_presence) {
        this.user_presence = user_presence;
    }


    public Map<Long, UserPresence> getUser_presence() {
        return user_presence;
    }

    public void setUser_presence(Map<Long, UserPresence> user_presence) {
        this.user_presence = user_presence;
    }


    public static class UserPresence {
        @JsonProperty("is_active")
        private boolean is_active;
        private long last_activity_at_ms;

        public UserPresence(boolean is_active, long last_activity_at_ms) {
            this.is_active = is_active;
            this.last_activity_at_ms = last_activity_at_ms;
        }

        public boolean isIs_active() {
            return is_active;
        }

        public void setIs_active(boolean is_active) {
            this.is_active = is_active;
        }

        public long getLast_activity_at_ms() {
            return last_activity_at_ms;
        }

        public void setLast_activity_at_ms(long last_activity_at_ms) {
            this.last_activity_at_ms = last_activity_at_ms;
        }
    }
}
