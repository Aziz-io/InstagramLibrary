package com.example.insta_test.requests.users;

import androidx.annotation.NonNull;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.users.UsersSearchResponse;


public class UsersSearchRequest extends IGGetRequest<UsersSearchResponse> {
    @NonNull
    private String query;
    private int timezone_offset = 3600;
    private String rank_token;
    private String page_token;
    private final String search_surface = "user_search_page";
    private final int count = 30;

    public UsersSearchRequest(String query) {
        this.query = query;
    }

    @NonNull
    public String getQuery() {
        return query;
    }

    public void setQuery(@NonNull String query) {
        this.query = query;
    }

    public int getTimezone_offset() {
        return timezone_offset;
    }

    public void setTimezone_offset(int timezone_offset) {
        this.timezone_offset = timezone_offset;
    }

    public String getRank_token() {
        return rank_token;
    }

    public void setRank_token(String rank_token) {
        this.rank_token = rank_token;
    }

    public String getPage_token() {
        return page_token;
    }

    public void setPage_token(String page_token) {
        this.page_token = page_token;
    }

    public String getSearch_surface() {
        return search_surface;
    }

    public int getCount() {
        return count;
    }

    public UsersSearchRequest(String query, int timezone_offset, String rank_token, String page_token) {
        this.query = query;
        this.timezone_offset = timezone_offset;
        this.rank_token = rank_token;
        this.page_token = page_token;
    }

    public UsersSearchRequest(String _query, String _rank_token, String _page_token) {
        this.query = _query;
        this.rank_token = _rank_token;
        this.page_token = _page_token;
    }

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("search_surface", search_surface, "timezone_offset",
                timezone_offset, "q", query, "count", count, "rank_token", rank_token, "page_token",
                page_token);
    }

    @Override
    public String path() {
        return "users/search/";
    }

    @Override
    public Class<UsersSearchResponse> getResponseType() {
        return UsersSearchResponse.class;
    }


}
