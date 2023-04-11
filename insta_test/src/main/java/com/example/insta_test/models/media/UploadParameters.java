package com.example.insta_test.models.media;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.example.insta_test.utils.IGUtils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class UploadParameters {
    @Builder.Default
    private String retry_context =
            "{\"num_step_auto_retry\":0,\"num_reupload\":0,\"num_step_manual_retry\":0}";
    private String media_type;
    @Builder.Default
    private Object[] xsharing_user_ids = new Object[] {};
    private String image_compression;
    private String upload_id;
    private String is_sidecar;
    private String for_album;
    private String direct_v2;
    private String for_direct_story;
    private String is_igtv_video;
    private String is_direct_voice;
    private String broadcast_id;
    private String is_post_live_igtv;


    public String getRetry_context() {
        return retry_context;
    }

    public void setRetry_context(String retry_context) {
        this.retry_context = retry_context;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public Object[] getXsharing_user_ids() {
        return xsharing_user_ids;
    }

    public void setXsharing_user_ids(Object[] xsharing_user_ids) {
        this.xsharing_user_ids = xsharing_user_ids;
    }

    public String getImage_compression() {
        return image_compression;
    }

    public void setImage_compression(String image_compression) {
        this.image_compression = image_compression;
    }

    public String getUpload_id() {
        return upload_id;
    }

    public void setUpload_id(String upload_id) {
        this.upload_id = upload_id;
    }

    public String getIs_sidecar() {
        return is_sidecar;
    }

    public void setIs_sidecar(String is_sidecar) {
        this.is_sidecar = is_sidecar;
    }

    public String getFor_album() {
        return for_album;
    }

    public void setFor_album(String for_album) {
        this.for_album = for_album;
    }

    public String getDirect_v2() {
        return direct_v2;
    }

    public void setDirect_v2(String direct_v2) {
        this.direct_v2 = direct_v2;
    }

    public String getFor_direct_story() {
        return for_direct_story;
    }

    public void setFor_direct_story(String for_direct_story) {
        this.for_direct_story = for_direct_story;
    }

    public String getIs_igtv_video() {
        return is_igtv_video;
    }

    public void setIs_igtv_video(String is_igtv_video) {
        this.is_igtv_video = is_igtv_video;
    }

    public String getIs_direct_voice() {
        return is_direct_voice;
    }

    public void setIs_direct_voice(String is_direct_voice) {
        this.is_direct_voice = is_direct_voice;
    }

    public String getBroadcast_id() {
        return broadcast_id;
    }

    public void setBroadcast_id(String broadcast_id) {
        this.broadcast_id = broadcast_id;
    }

    public String getIs_post_live_igtv() {
        return is_post_live_igtv;
    }

    public void setIs_post_live_igtv(String is_post_live_igtv) {
        this.is_post_live_igtv = is_post_live_igtv;
    }

    @Override
    public String toString() {
        return IGUtils.objectToJson(this);
    }

    public static UploadParameters forPhoto(String upload_id, String media_type,
            boolean is_sidecar, String broadcastId) {
        return UploadParameters.builder().upload_id(upload_id).media_type(media_type)
                .is_sidecar(is_sidecar ? "1" : null)
                .broadcast_id(broadcastId)
                .is_post_live_igtv(broadcastId != null ? "1" : null)
                .image_compression(
                        "{\"lib_name\":\"moz\",\"lib_version\":\"3.1.m\",\"quality\":\"80\"}")
                .build();
    }

    public static UploadParameters forTimelineVideo(String upload_id, boolean is_sidecar) {
        return UploadParameters.builder().upload_id(upload_id).media_type("2")
                .is_sidecar(is_sidecar ? "1" : null)
                .build();
    }

    public static UploadParameters forAlbumVideo(String upload_id) {
        return UploadParameters.builder().upload_id(upload_id).media_type("2").for_album("1")
                .build();
    }

    public static UploadParameters forDirectVideo(String upload_id) {
        return UploadParameters.builder().upload_id(upload_id).media_type("2").direct_v2("1")
                .build();
    }

    public static UploadParameters forDirectVoice(String upload_id) {
        return UploadParameters.builder().upload_id(upload_id).media_type("11").is_direct_voice("1")
                .build();
    }

    public static UploadParameters forIgtv(String upload_id) {
        return UploadParameters.builder().upload_id(upload_id).is_igtv_video("1").build();
    }
}
