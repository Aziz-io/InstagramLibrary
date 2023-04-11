package com.example.insta_test.responses.direct;

import com.example.insta_test.models.direct.Inbox;
import com.example.insta_test.models.user.User;
import com.example.insta_test.responses.IGResponse;

import lombok.Data;

@Data
public class DirectInboxResponse extends IGResponse {
    private User viewer;
    private Inbox inbox;
    private int seq_id;
    private int pending_requests_total;
    private User most_recent_inviter;
}
