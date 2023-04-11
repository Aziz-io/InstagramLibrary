package com.example.insta_test.responses;

import com.example.insta_test.models.IGBaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;




public class IGResponse extends IGBaseModel {
    private String status;
    @JsonIgnore
    private int statusCode;
    private String message;
    private boolean spam;
    private boolean lock;
    private String feedback_title;
    private String feedback_message;
    private String error_type;
    private String checkpoint_url;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public String getFeedback_title() {
        return feedback_title;
    }

    public void setFeedback_title(String feedback_title) {
        this.feedback_title = feedback_title;
    }

    public String getFeedback_message() {
        return feedback_message;
    }

    public void setFeedback_message(String feedback_message) {
        this.feedback_message = feedback_message;
    }

    public String getError_type() {
        return error_type;
    }

    public void setError_type(String error_type) {
        this.error_type = error_type;
    }

    public String getCheckpoint_url() {
        return checkpoint_url;
    }

    public void setCheckpoint_url(String checkpoint_url) {
        this.checkpoint_url = checkpoint_url;
    }
}
