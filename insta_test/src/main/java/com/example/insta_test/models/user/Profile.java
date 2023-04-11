package com.example.insta_test.models.user;

import androidx.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.insta_test.models.IGBaseModel;

import java.io.Serializable;

import lombok.EqualsAndHashCode;


public class Profile extends IGBaseModel implements Serializable {
    private static final long serialVersionUID = -892648357982l;
    @EqualsAndHashCode.Include
    private Long pk;
    private String username;
    private String full_name;
    @JsonProperty("is_private")
    private boolean is_private;
    private String profile_pic_url;
    private String profile_pic_id;
    @JsonProperty("is_verified")
    private boolean is_verified;
    private boolean has_anonymous_profile_picture;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public boolean isIs_private() {
        return is_private;
    }

    public void setIs_private(boolean is_private) {
        this.is_private = is_private;
    }

    public String getProfile_pic_url() {
        return profile_pic_url;
    }

    public void setProfile_pic_url(String profile_pic_url) {
        this.profile_pic_url = profile_pic_url;
    }

    public String getProfile_pic_id() {
        return profile_pic_id;
    }

    public void setProfile_pic_id(String profile_pic_id) {
        this.profile_pic_id = profile_pic_id;
    }

    public boolean isIs_verified() {
        return is_verified;
    }

    public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
    }

    public boolean isHas_anonymous_profile_picture() {
        return has_anonymous_profile_picture;
    }

    public void setHas_anonymous_profile_picture(boolean has_anonymous_profile_picture) {
        this.has_anonymous_profile_picture = has_anonymous_profile_picture;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}
