package com.example.insta_test.models.media;
import com.example.insta_test.models.IGBaseModel;
import com.example.insta_test.models.media.timeline.Comment.Caption;
import com.example.insta_test.models.user.User;

import lombok.Data;

@Data
public class Media extends IGBaseModel {
    private long pk;
    private String id;
    private long taken_at;
    private long device_timestamp;
    private String media_type;
    private String code;
    private String client_cache_key;
    private int filter_type;
    private User user;
    private Caption caption;
    private boolean can_viewer_reshare;
    private boolean photo_of_you;
    private boolean can_viewer_save;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTaken_at() {
        return taken_at;
    }

    public void setTaken_at(long taken_at) {
        this.taken_at = taken_at;
    }

    public long getDevice_timestamp() {
        return device_timestamp;
    }

    public void setDevice_timestamp(long device_timestamp) {
        this.device_timestamp = device_timestamp;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClient_cache_key() {
        return client_cache_key;
    }

    public void setClient_cache_key(String client_cache_key) {
        this.client_cache_key = client_cache_key;
    }

    public int getFilter_type() {
        return filter_type;
    }

    public void setFilter_type(int filter_type) {
        this.filter_type = filter_type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Caption getCaption() {
        return caption;
    }

    public void setCaption(Caption caption) {
        this.caption = caption;
    }

    public boolean isCan_viewer_reshare() {
        return can_viewer_reshare;
    }

    public void setCan_viewer_reshare(boolean can_viewer_reshare) {
        this.can_viewer_reshare = can_viewer_reshare;
    }

    public boolean isPhoto_of_you() {
        return photo_of_you;
    }

    public void setPhoto_of_you(boolean photo_of_you) {
        this.photo_of_you = photo_of_you;
    }

    public boolean isCan_viewer_save() {
        return can_viewer_save;
    }

    public void setCan_viewer_save(boolean can_viewer_save) {
        this.can_viewer_save = can_viewer_save;
    }
}