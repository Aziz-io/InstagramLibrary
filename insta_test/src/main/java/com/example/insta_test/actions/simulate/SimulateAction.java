package com.example.insta_test.actions.simulate;

import com.example.insta_test.IGClient;
import com.example.insta_test.actions.async.AsyncAction;
import com.example.insta_test.requests.IGRequest;
import com.example.insta_test.requests.accounts.AccountsContactPointPrefillRequest;
import com.example.insta_test.requests.accounts.AccountsGetPrefillCandidatesRequest;
import com.example.insta_test.requests.direct.DirectGetPresenceRequest;
import com.example.insta_test.requests.direct.DirectInboxRequest;
import com.example.insta_test.requests.discover.DiscoverTopicalExploreRequest;
import com.example.insta_test.requests.feed.FeedReelsTrayRequest;
import com.example.insta_test.requests.feed.FeedTimelineRequest;
import com.example.insta_test.requests.launcher.LauncherSyncRequest;
import com.example.insta_test.requests.linkedaccounts.LinkedAccountsGetLinkageStatusRequest;
import com.example.insta_test.requests.loom.LoomFetchConfigRequest;
import com.example.insta_test.requests.media.MediaBlockedRequest;
import com.example.insta_test.requests.multipleaccounts.MultipleAccountsGetAccountFamilyRequest;
import com.example.insta_test.requests.news.NewsInboxRequest;
import com.example.insta_test.requests.qe.QeSyncRequest;
import com.example.insta_test.requests.qp.QpGetCooldowns;
import com.example.insta_test.requests.status.StatusGetViewableStatusesRequest;
import com.example.insta_test.requests.users.UsersArlinkDownloadInfoRequest;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SimulateAction {
    @NonNull
    private IGClient client;

    private static final IGRequest<?>[] preLoginFlow = {
            new LauncherSyncRequest(true),
            new QeSyncRequest(true),
            new AccountsContactPointPrefillRequest(),
            new AccountsGetPrefillCandidatesRequest()
    };

    private static final IGRequest<?>[] postLoginFlow = {
            new LauncherSyncRequest(),
            new QpGetCooldowns(),
            new MultipleAccountsGetAccountFamilyRequest(),
            new LinkedAccountsGetLinkageStatusRequest(),
            new LoomFetchConfigRequest(),
            new MediaBlockedRequest(),
            new FeedTimelineRequest(),
            new FeedReelsTrayRequest(),
            new UsersArlinkDownloadInfoRequest(),
            new DiscoverTopicalExploreRequest().is_prefetch(true),
            new NewsInboxRequest(false),
            new DirectGetPresenceRequest(),
            new DirectInboxRequest().limit(0).visual_message_return_type("unseen")
                    .persistent_badging(true),
            new DirectInboxRequest().limit(20).fetch_reason("initial_snapshot")
                    .thread_message_limit(10).visual_message_return_type("unseen")
                    .persistent_badging(true),
            new StatusGetViewableStatusesRequest()
    };

    public List<CompletableFuture<?>> preLoginFlow() {
        return AsyncAction.executeRequestsAsync(client, preLoginFlow);
    }

    public List<CompletableFuture<?>> postLoginFlow() {
        return AsyncAction.executeRequestsAsync(client, postLoginFlow);
    }
}
