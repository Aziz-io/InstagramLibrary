package com.example.insta_test.exceptions;

import com.example.insta_test.responses.IGResponse;
import com.example.insta_test.utils.IGUtils;

import java.io.IOException;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class IGResponseException extends IOException {
    @NonNull
    private IGResponse response;

    public IGResponseException(IGResponse response) {
        super(response.getMessage());
        this.response = response;
    }

    @Data
    public static class IGFailedResponse extends IGResponse {
        private String status = "fail";
        private String message;

        public IGFailedResponse(String toString) {
            super();
        }

        public static IGResponse of(Throwable throwable) {
            if (throwable instanceof IGResponseException)
                return ((IGResponseException) throwable).getResponse();
            return new IGFailedResponse(throwable.toString());
        }

        public static <T> T of(Throwable throwable, Class<T> clazz) {
            return IGUtils.convertToView(of(throwable), clazz);
        }
    }

}
