package com.example.insta_test.responses.creatives;

import com.example.insta_test.models.creatives.StaticSticker;
import com.example.insta_test.responses.IGResponse;

import java.util.List;






public class CreativesAssetsResponse extends IGResponse {
    private List<StaticSticker> static_stickers;


    public List<StaticSticker> getStatic_stickers() {
        return static_stickers;
    }

    public void setStatic_stickers(List<StaticSticker> static_stickers) {
        this.static_stickers = static_stickers;
    }
}
