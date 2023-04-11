package com.example.insta_test.responses.direct;

import com.example.insta_test.models.direct.IGThread;
import com.example.insta_test.responses.IGResponse;



public class DirectThreadsResponse extends IGResponse {
    private IGThread thread;

    public DirectThreadsResponse(IGThread thread) {
        this.thread = thread;
    }

    public IGThread getThread() {
        return thread;
    }

    public void setThread(IGThread thread) {
        this.thread = thread;
    }
}
