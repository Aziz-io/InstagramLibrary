package com.example.insta_test.requests.news;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGGetRequest;
import com.example.insta_test.responses.news.NewsInboxResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class NewsInboxRequest extends IGGetRequest<NewsInboxResponse> {
    private Boolean mark_as_seen;

    @Override
    public String path() {
        return "news/inbox/";
    }

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("mark_as_seen", mark_as_seen);
    }

    @Override
    public Class<NewsInboxResponse> getResponseType() {
        return NewsInboxResponse.class;
    }

}
