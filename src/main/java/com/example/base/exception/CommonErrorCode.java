package com.example.base.exception;

import org.springframework.http.HttpStatus;

public enum CommonErrorCode implements ErrorCode {
    UNAUTHORIZED_ACCESS("UNAUTHORIZED", HttpStatus.UNAUTHORIZED, "Unauthorized access");

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    CommonErrorCode(String code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
