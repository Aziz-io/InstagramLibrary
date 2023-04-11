package com.example.insta_test.actions.media;

import com.example.insta_test.IGClient;
import com.example.insta_test.actions.feed.FeedIterable;
import com.example.insta_test.requests.media.MediaActionRequest;
import com.example.insta_test.requests.media.MediaCommentRequest;
import com.example.insta_test.requests.media.MediaConfigureSidecarRequest;
import com.example.insta_test.requests.media.MediaConfigureSidecarRequest.MediaConfigureSidecarPayload;
import com.example.insta_test.requests.media.MediaConfigureTimelineRequest;
import com.example.insta_test.requests.media.MediaConfigureTimelineRequest.MediaConfigurePayload;
import com.example.insta_test.requests.media.MediaConfigureToIgtvRequest;
import com.example.insta_test.requests.media.MediaEditRequest;
import com.example.insta_test.requests.media.MediaGetCommentsRequest;
import com.example.insta_test.requests.media.MediaInfoRequest;
import com.example.insta_test.responses.IGResponse;
import com.example.insta_test.responses.media.MediaCommentResponse;
import com.example.insta_test.responses.media.MediaGetCommentsResponse;
import com.example.insta_test.responses.media.MediaInfoResponse;
import com.example.insta_test.responses.media.MediaResponse;
import com.example.insta_test.responses.media.MediaResponse.MediaConfigureSidecarResponse;
import com.example.insta_test.responses.media.MediaResponse.MediaConfigureTimelineResponse;
import com.example.insta_test.responses.media.MediaResponse.MediaConfigureToIgtvResponse;

import java.util.concurrent.CompletableFuture;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MediaAction {
    @NonNull
    private IGClient client;
    @NonNull
    private String media_id;
    
    public CompletableFuture<MediaCommentResponse> comment(String comment) {
        return new MediaCommentRequest(media_id, comment).execute(client);
    }
    
    public CompletableFuture<MediaResponse> editCaption(String caption) {
        return new MediaEditRequest(media_id, caption).execute(client);
    }
    
    public CompletableFuture<MediaInfoResponse> info() {
        return new MediaInfoRequest(media_id).execute(client);
    }
    
    public FeedIterable<MediaGetCommentsRequest, MediaGetCommentsResponse> comments() {
        return new FeedIterable<>(client, () -> new MediaGetCommentsRequest(media_id));
    }
    
    public CompletableFuture<IGResponse> action(MediaActionRequest.MediaAction action) {
        return new MediaActionRequest(media_id, action).execute(client);
    }
    
    public static MediaAction of(IGClient client, String media_id) {
        return new MediaAction(client, media_id);
    }
    
    public static CompletableFuture<MediaConfigureTimelineResponse> configureMediaToTimeline(IGClient client, String upload_id, MediaConfigurePayload payload) {
        return new MediaConfigureTimelineRequest(payload.upload_id(upload_id)).execute(client);
    }
    
    public static CompletableFuture<MediaConfigureSidecarResponse> configureAlbumToTimeline(IGClient client, MediaConfigureSidecarPayload payload) {
        return new MediaConfigureSidecarRequest(payload).execute(client);
    }
    
    public static CompletableFuture<MediaConfigureToIgtvResponse> configureToIgtv(IGClient client, String upload_id, String title, String caption, boolean postToFeed) {
        return new MediaConfigureToIgtvRequest(upload_id, title, caption, postToFeed).execute(client);
    }
}
