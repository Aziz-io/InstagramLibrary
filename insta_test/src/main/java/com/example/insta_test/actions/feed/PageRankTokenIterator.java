package com.example.insta_test.actions.feed;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGPageRankTokenRequest;
import com.example.insta_test.requests.IGRequest;
import com.example.insta_test.responses.IGPageRankTokenResponse;
import com.example.insta_test.responses.IGResponse;

public class PageRankTokenIterator<T extends IGRequest<R> & IGPageRankTokenRequest, R extends IGResponse & IGPageRankTokenResponse>
        extends CursorIterator<IGRequest<R>, R> {
    
    public PageRankTokenIterator(IGClient client, T t) {
        super(client, t, (req, id) -> IGPageRankTokenResponse.setFromFormat((IGPageRankTokenRequest) req, id), (res) -> res.toNextId(), (res) -> res.isHas_more());
    }
    
}
