package com.example.insta_test.actions.account;

import com.example.insta_test.IGClient;
import com.example.insta_test.requests.accounts.*;
import com.example.insta_test.requests.accounts.AccountsActionRequest.AccountsAction;
import com.example.insta_test.responses.IGResponse;
import com.example.insta_test.responses.accounts.AccountsUserResponse;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.util.concurrent.CompletableFuture;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountAction {
    @NonNull
    private IGClient client;

    public CompletableFuture<AccountsUserResponse> setProfilePicture(byte[] photo) {
        return client.actions().upload()
                .photo(photo, String.valueOf(System.currentTimeMillis()))
                .thenCompose(res -> new AccountsChangeProfilePictureRequest(res.getUpload_id())
                        .execute(client));
    }
    
    public CompletableFuture<AccountsUserResponse> setProfilePicture(File file) {
        try {
            return setProfilePicture(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
    
    public CompletableFuture<IGResponse> setBio(String bio) {
        return new AccountsSetBiographyRequest(bio).execute(client);
    }
    
    public CompletableFuture<AccountsUserResponse> action(AccountsAction action) {
        return new AccountsActionRequest(action).execute(client);
    }
    
    public CompletableFuture<AccountsUserResponse> currentUser() {
        return new AccountsCurrentUserRequest().execute(client);
    }
}
