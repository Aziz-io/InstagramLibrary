package com.example.insta_test.responses.media;

import com.example.insta_test.models.media.Media;
import com.example.insta_test.models.media.reel.ReelMedia;
import com.example.insta_test.models.media.timeline.TimelineMedia;
import com.example.insta_test.models.media.timeline.TimelineVideoMedia;
import com.example.insta_test.responses.IGResponse;
import lombok.Data;

@Data
public class MediaResponse extends IGResponse {
    private Media media;

    @Data
    public static class MediaConfigureTimelineResponse extends MediaResponse {
        private TimelineMedia media;
    }

    @Data
    public static class MediaConfigureSidecarResponse extends MediaConfigureTimelineResponse {
        private String client_sidecar_id;
    }

    @Data
    public static class MediaConfigureToStoryResponse extends MediaResponse {
        private ReelMedia media;
    }

    @Data
    public static class MediaConfigureToIgtvResponse extends MediaResponse {
        private TimelineVideoMedia media;
    }
}
