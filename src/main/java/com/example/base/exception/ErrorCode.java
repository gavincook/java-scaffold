package com.example.base.exception;

import com.example.base.api.response.ResponseCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode implements ResponseCode {
    FAILED("FAILED", HttpStatus.INTERNAL_SERVER_ERROR, "Failed"),
    UNAUTHORIZED("UNAUTHORIZED", HttpStatus.UNAUTHORIZED, "Unauthorized access");

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    ErrorCode(String code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
