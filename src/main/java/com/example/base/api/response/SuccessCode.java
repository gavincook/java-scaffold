package com.example.base.api.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SuccessCode implements ResponseCode {
    SUCCESS("SUCCESS", HttpStatus.OK, "success");

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    SuccessCode(String code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
