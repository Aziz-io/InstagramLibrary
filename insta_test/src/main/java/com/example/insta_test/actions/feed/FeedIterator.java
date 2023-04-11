package com.example.insta_test.actions.feed;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGPaginatedRequest;
import com.example.insta_test.requests.IGRequest;
import com.example.insta_test.responses.IGPaginatedResponse;
import com.example.insta_test.responses.IGResponse;

public class FeedIterator<T extends IGRequest<R> & IGPaginatedRequest, R extends IGResponse & IGPaginatedResponse>
        extends CursorIterator<IGRequest<R>, R> {

    public FeedIterator(IGClient client, T t) {
        super(client, t, (request, id) -> t.setMax_id(id), (e) -> e.getNext_max_id(), (e) -> e.isMore_available());
    }

}
