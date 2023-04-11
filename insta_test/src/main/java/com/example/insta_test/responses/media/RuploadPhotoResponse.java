package com.example.insta_test.responses.media;

import com.example.insta_test.responses.IGResponse;


import lombok.Data;

@Data
public class RuploadPhotoResponse extends IGResponse {
    private String upload_id;
}
