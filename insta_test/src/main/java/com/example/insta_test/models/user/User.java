package com.example.insta_test.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

import lombok.Data;



public class User extends Profile {
    @JsonProperty("is_business")
    private boolean is_business;
    private int media_count;
    private int follower_count;
    private int following_count;
    private String biography;
    private String external_url;
    private List<ProfilePic> hd_profile_pic_versions;
    private ProfilePic hd_profile_pic_url_info;
    private int account_type;


    public boolean isIs_business() {
        return is_business;
    }

    public void setIs_business(boolean is_business) {
        this.is_business = is_business;
    }

    public int getMedia_count() {
        return media_count;
    }

    public void setMedia_count(int media_count) {
        this.media_count = media_count;
    }

    public int getFollower_count() {
        return follower_count;
    }

    public void setFollower_count(int follower_count) {
        this.follower_count = follower_count;
    }

    public int getFollowing_count() {
        return following_count;
    }

    public void setFollowing_count(int following_count) {
        this.following_count = following_count;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getExternal_url() {
        return external_url;
    }

    public void setExternal_url(String external_url) {
        this.external_url = external_url;
    }

    public List<ProfilePic> getHd_profile_pic_versions() {
        return hd_profile_pic_versions;
    }

    public void setHd_profile_pic_versions(List<ProfilePic> hd_profile_pic_versions) {
        this.hd_profile_pic_versions = hd_profile_pic_versions;
    }

    public ProfilePic getHd_profile_pic_url_info() {
        return hd_profile_pic_url_info;
    }

    public void setHd_profile_pic_url_info(ProfilePic hd_profile_pic_url_info) {
        this.hd_profile_pic_url_info = hd_profile_pic_url_info;
    }

    public int getAccount_type() {
        return account_type;
    }

    public void setAccount_type(int account_type) {
        this.account_type = account_type;
    }

    @Data
    public static class ProfilePic implements Serializable {
        public String url;
        public int width;
        public int height;


        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
