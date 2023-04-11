package com.example.insta_test.requests.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.accounts.AccountsUserResponse;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
public class AccountsEditProfileRequest extends IGPostRequest<AccountsUserResponse> {
    @NonNull
    private AccountsEditProfilePayload payload;

    @Override
    protected IGPayload getPayload(IGClient client) {
        return payload;
    }

    @Override
    public String path() {
        return "accounts/edit_profile/";
    }

    @Override
    public Class<AccountsUserResponse> getResponseType() {
        return AccountsUserResponse.class;
    }

    @Data
    @Accessors(fluent = true)
    public static class AccountsEditProfilePayload extends IGPayload {
        @JsonProperty("first_name")
        private String first_name;
        @JsonProperty("biography")
        private String biography;
        @NonNull
        @JsonProperty("username")
        private final String username;
        @JsonProperty("phone_number")
        private String phone_number;
        @NonNull
        @JsonProperty("email")
        private final String email;
        @JsonProperty("external_url")
        private String external_url;
    }

}
