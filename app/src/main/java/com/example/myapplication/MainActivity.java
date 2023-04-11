package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;


import com.example.insta_test.IGClient;
import com.example.insta_test.models.media.ImageVersions;
import com.example.insta_test.models.media.ImageVersionsMeta;
import com.example.insta_test.models.media.timeline.CarouselItem;
import com.example.insta_test.models.media.timeline.ImageCarouselItem;
import com.example.insta_test.models.media.timeline.TimelineCarouselMedia;
import com.example.insta_test.models.media.timeline.TimelineImageMedia;
import com.example.insta_test.models.media.timeline.TimelineMedia;
import com.example.insta_test.models.media.timeline.TimelineVideoMedia;
import com.example.insta_test.models.media.timeline.VideoCarouselItem;
import com.example.insta_test.requests.feed.FeedTimelineRequest;
import com.example.insta_test.responses.feed.FeedTimelineResponse;
import com.example.insta_test.session.TempClass;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private static IGClient client;
    public static final String TAG = MainActivity.class.getSimpleName();

    public static final String BLANK_STRING_KEY = "";
    public static final String WRONG_PAIR = "Key-Value pair cannot be blank or null";


    private SharedPreferences savedSession;

    @SuppressLint("SdCardPath")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {


            // use the shared preferences and editor as you normally would


            savedSession = TempClass.mainData(this);
            Scanner scanner = new Scanner(System.in);

            String internalStorage = getFilesDir().getAbsolutePath();
            String rootPath = internalStorage + "/instaSave";
            File file = new File(rootPath);
            if (!file.exists()) {
                if (file.mkdir()) {
                    Log.e(TAG, "Root path Created");
                }
            }
            File clientFile = new File(rootPath, "client");
            File cookieFile = new File(rootPath, "cookie");

            if (clientFile.createNewFile()) {
                Log.e(TAG, "Client File Created");

            }
            if (cookieFile.createNewFile()) {
                Log.e(TAG, "Cookie File Created");
            }

            if (!savedSession.getBoolean("session", false)) {
                client = IGClient.builder()
                        .username("biteshare8@gmail.com")
                        .password("test2023@@")
//                    .onChallenge(challengeHandler)
                        .login();

                try {
                    client.serialize(clientFile, cookieFile);
                    TempClass.put("session", true);
                    Log.e(TAG, "Saved in file" + client.getAuthorization());
                } catch (IOException e) {
                    TempClass.put("session", false);
                    Log.e(TAG, "Got Exception saving client " + e.getMessage());
                }
            } else {
                client = IGClient.deserialize(clientFile, cookieFile);
//                Log.e(TAG, "Static" + client.getAuthorization());
            }

//"aziz_hear" , "theinformation"
//UserName to get from NewsFeed
            // UserName to get from NewsFeed
// UserName to get from NewsFeed
            String userName = "aziz_hear";

// Get the current date
            Date currentDate = new Date();

// Calculate the date two days ago
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            calendar.add(Calendar.DAY_OF_YEAR, -2);
            Date twoDaysAgo = calendar.getTime();

// Initialize the max_id parameter to null for the first request
            String maxId = null;

// Fetch the newsfeed using the client
            do {
                // Create a new request with the max_id parameter
                FeedTimelineRequest request = new FeedTimelineRequest();
                request.setCount(50); // set the count parameter to 50 to retrieve 50 newsfeeds
                if (maxId != null) {
                    request.setMax_id(maxId); // set the max_id parameter for subsequent requests
                }

                // Execute the request
                FeedTimelineResponse response = request.execute(client).join();

                // Loop through each post in the response
                for (TimelineMedia media : response.getFeed_items()) {
                    // Check if the post is from the specified user and is from the past two days
                    if (media.getUser().getUsername().equals(userName)) {
                        Date postDate = new Date(media.getTaken_at() * 1000);
                        if (postDate.after(twoDaysAgo) || postDate.equals(twoDaysAgo) || postDate.after(currentDate)) {
                            // Determine the media type of the post (image, video, carousel)
                            if (media instanceof TimelineImageMedia) {
                                TimelineImageMedia imageMedia = (TimelineImageMedia) media;
                                // Get the caption text
                                String caption = "";
                                if (imageMedia.getCaption() != null) {
                                    caption = imageMedia.getCaption().getText();
                                }
                                // Get the URL of the first image candidate
                                String imageUrl = "";
                                ImageVersions imageVersions = imageMedia.getImage_versions2();
                                if (imageVersions != null) {
                                    List<ImageVersionsMeta> candidates = imageVersions.getCandidates();
                                    if (candidates != null && candidates.size() > 0) {
                                        imageUrl = candidates.get(0).getUrl();
                                    }
                                }
                                // Log the caption and image URL
                                Log.e(TAG, "[ ImageMedia - Caption: " + caption + ", Image URL: " + imageUrl + " ]\n");
                            } else if (media instanceof TimelineVideoMedia) {
                                TimelineVideoMedia videoMedia = (TimelineVideoMedia) media;
                                // Check if the video has a caption and get the text
                                String text = "";
                                if (videoMedia.getCaption() != null) {
                                    text = videoMedia.getCaption().getText();
                                }
                                // Check if the video has a cover image and get the URL
                                String coverImageUrl = "";
                                if (videoMedia.getImage_versions2() != null && videoMedia.getImage_versions2().getCandidates() != null
                                        && videoMedia.getImage_versions2().getCandidates().size() > 0) {
                                    coverImageUrl = videoMedia.getImage_versions2().getCandidates().get(0).getUrl();
                                }
                                // Get the video URL
                                String videoUrl = "";
                                if (videoMedia.getVideo_versions() != null && videoMedia.getVideo_versions().size() > 0) {
                                    videoUrl = videoMedia.getVideo_versions().get(0).getUrl();
                                }
                                // Log the video details
                                Log.e(TAG, "[ VideoMedia - Text: " + text + ", Cover Image URL: " + coverImageUrl
                                        + ", Video URL: " + videoUrl + " ]\n");
                            } else if (media instanceof TimelineCarouselMedia) {
                                TimelineCarouselMedia carouselMedia = (TimelineCarouselMedia) media;
                                List<CarouselItem> carouselItems = carouselMedia.getCarousel_media();
                                for (int i = 0; i < carouselItems.size(); i++) {
                                    CarouselItem item = carouselItems.get(i);
                                    if (item instanceof ImageCarouselItem) {
                                        ImageCarouselItem imageMedia = (ImageCarouselItem) item;
                                        // Get the caption text
                                        String caption = "";
                                        if (carouselMedia.getCaption() != null) {
                                            caption = carouselMedia.getCaption().getText();
                                        }
                                        // Get the URL of the first image candidate
                                        String imageUrl = "";
                                        ImageVersions imageVersions = imageMedia.getImage_versions2();
                                        if (imageVersions != null) {
                                            List<ImageVersionsMeta> candidates = imageVersions.getCandidates();
                                            if (candidates != null && candidates.size() > 0) {
                                                imageUrl = candidates.get(0).getUrl();
                                            }
                                        }
                                        // Log the caption and image URL
                                        Log.e(TAG, "[ Carousel - Image " + (i + 1) + " - Caption: " + caption + ", Image URL: " + imageUrl + " ]\n");
                                    } else if (item instanceof VideoCarouselItem) {
                                        VideoCarouselItem videoMedia = (VideoCarouselItem) item;
                                        // Check if the video has a caption and get the text
                                        String text = "";
                                        if (videoMedia.getCaption() != null) {
                                            text = videoMedia.getCaption().getText();
                                        }
                                        // Check if the video has a cover image and get the URL
                                        String coverImageUrl = "";
                                        if (videoMedia.getImage_versions2() != null && videoMedia.getImage_versions2().getCandidates() != null
                                                && videoMedia.getImage_versions2().getCandidates().size() > 0) {
                                            coverImageUrl = videoMedia.getImage_versions2().getCandidates().get(0).getUrl();
                                        }
                                        // Get the video URL
                                        String videoUrl = "";
                                        if (videoMedia.getVideo_versions() != null && videoMedia.getVideo_versions().size() > 0) {
                                            videoUrl = videoMedia.getVideo_versions().get(0).getUrl();
                                        }
                                        // Log the video details
                                        Log.e(TAG, "[ Carousel - Video " + (i + 1) + " - caption: " + text + ", Cover Image URL: " + coverImageUrl
                                                + ", Video URL: " + videoUrl + " ]\n");
                                    }
                                }
                            }
                        }
                    }
                }

                // Get the next_max_id value from the response
                String nextMaxId = response.getNext_max_id();
                if (nextMaxId != null && !nextMaxId.equals(maxId)) {
                    maxId = nextMaxId;
                } else {
                    // If the next_max_id value is null or equal to the previous max_id value,
                    // break out of the loop to stop making additional requests
                    break;
                }
            } while (true);
            File file1 = new File(rootPath + "/dl.jpg");
            if (file1.exists()) {
                Bitmap bitmap = TempClass.resizeBitmap(file1.getPath(), 1080, 1347);
                File f = TempClass.savebitmap(rootPath + "/dl.jpg", bitmap);
                if (f.exists()) {
                    Log.e(TAG, "File found");
                    new Handler(Looper.getMainLooper()).postDelayed(() -> {
                                client.actions()
                                        .timeline()
                                        .uploadPhoto(f, "My fourth pic for Demo")
                                        .thenAccept(response -> {
                                            Log.e(TAG, "Successfully uploaded photo!");
                                        })
                                        .join();
                            }
                            , 1000);
                }
            } else {
                Log.e(TAG, "File not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "Got Exception " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Got Exception " + e.getMessage());
            e.printStackTrace();
        }
    }

    public enum MediaType {
        CAROUSAL("8"),
        IMAGE("1"),
        VIDEO("2");

        private final String value;

        MediaType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}