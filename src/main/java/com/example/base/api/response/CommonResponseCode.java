package com.example.base.api.response;

import lombok.Getter;

@Getter
public enum CommonResponseCode {
    SUCCESS("SUCCESS", "success"),
    FAILED("FAILED", "failed");

    private final String code;
    private final String message;

    CommonResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
