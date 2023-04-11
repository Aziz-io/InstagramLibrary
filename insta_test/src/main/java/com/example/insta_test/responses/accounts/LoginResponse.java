package com.example.insta_test.responses.accounts;

import com.example.insta_test.models.user.User;
import com.example.insta_test.responses.IGResponse;
import com.example.insta_test.responses.challenge.Challenge;



public class LoginResponse extends IGResponse {
    private User logged_in_user;
    private Challenge challenge;
    private TwoFactorInfo two_factor_info;

    public User getLogged_in_user() {
        return logged_in_user;
    }

    public void setLogged_in_user(User logged_in_user) {
        this.logged_in_user = logged_in_user;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public TwoFactorInfo getTwo_factor_info() {
        return two_factor_info;
    }

    public void setTwo_factor_info(TwoFactorInfo two_factor_info) {
        this.two_factor_info = two_factor_info;
    }

    public class TwoFactorInfo {
        private String two_factor_identifier;

        public String getTwo_factor_identifier() {
            return two_factor_identifier;
        }

        public void setTwo_factor_identifier(String two_factor_identifier) {
            this.two_factor_identifier = two_factor_identifier;
        }
    }
}
