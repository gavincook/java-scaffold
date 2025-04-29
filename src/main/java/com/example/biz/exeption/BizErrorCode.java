package com.example.biz.exeption;

import com.example.base.api.response.ResponseCode;
import org.springframework.http.HttpStatus;

public enum BizErrorCode implements ResponseCode {

    ;

    private String code;

    private String message;

    BizErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return null;
    }

    @Override
    public String getCode() {
        return "";
    }

    @Override
    public String getMessage() {
        return "";
    }
}
