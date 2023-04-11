package com.example.insta_test.responses.commerce;

import com.example.insta_test.models.discover.SectionalMediaGridItem;
import com.example.insta_test.responses.IGPaginatedResponse;
import com.example.insta_test.responses.IGResponse;

import java.util.List;




public class CommerceDestinationResponse extends IGResponse implements IGPaginatedResponse {
    private List<SectionalMediaGridItem> sectional_items;
    private String rank_token;
    private String next_max_id;
    private boolean more_available;

    public List<SectionalMediaGridItem> getSectional_items() {
        return sectional_items;
    }

    public void setSectional_items(List<SectionalMediaGridItem> sectional_items) {
        this.sectional_items = sectional_items;
    }

    public String getRank_token() {
        return rank_token;
    }

    public void setRank_token(String rank_token) {
        this.rank_token = rank_token;
    }

    @Override
    public String getNext_max_id() {
        return next_max_id;
    }

    public void setNext_max_id(String next_max_id) {
        this.next_max_id = next_max_id;
    }

    @Override
    public boolean isMore_available() {
        return more_available;
    }

    public void setMore_available(boolean more_available) {
        this.more_available = more_available;
    }
}
