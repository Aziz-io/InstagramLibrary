package com.example.insta_test.requests.accounts;

import androidx.annotation.NonNull;

import com.example.insta_test.IGClient;
import com.example.insta_test.models.IGPayload;
import com.example.insta_test.requests.IGPostRequest;
import com.example.insta_test.responses.accounts.AccountsUserResponse;




public class AccountsChangeProfilePictureRequest extends IGPostRequest<AccountsUserResponse> {
    @NonNull
    private String _upload_id;


    public AccountsChangeProfilePictureRequest(@NonNull String _upload_id) {
        this._upload_id = _upload_id;
    }

    @NonNull
    public String get_upload_id() {
        return _upload_id;
    }

    public void set_upload_id(@NonNull String _upload_id) {
        this._upload_id = _upload_id;
    }

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new IGPayload() {

            private String upload_id = _upload_id;

            public String getUpload_id() {
                return upload_id;
            }
        };
    }

    @Override
    public String path() {
        return "accounts/change_profile_picture/";
    }

    @Override
    public Class<AccountsUserResponse> getResponseType() {
        return AccountsUserResponse.class;
    }

}
