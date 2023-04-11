package com.example.insta_test.actions.feed;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.IGPaginatedRequest;
import com.example.insta_test.requests.IGRequest;
import com.example.insta_test.responses.IGPaginatedResponse;
import com.example.insta_test.responses.IGResponse;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FeedIterable<T extends IGRequest<R> & IGPaginatedRequest, R extends IGResponse & IGPaginatedResponse> implements Iterable<R> {
    @NonNull
    private IGClient client;
    @NonNull
    private Supplier<T> requestSupplier;

    @Override
    public Iterator<R> iterator() {
        return new FeedIterator<T, R>(client, requestSupplier.get());
    }

    @Override
    public Spliterator<R> spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), Spliterator.IMMUTABLE);
    }

    public Stream<R> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }
    
    public static <T extends IGRequest<R> & IGPaginatedRequest, R extends IGResponse & IGPaginatedResponse> FeedIterable<T, R> of(
            IGClient client, T t) {
        return new FeedIterable<>(client, () -> t);
    }

}
