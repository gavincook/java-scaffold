package com.example.base.api.response;

import com.example.base.exception.ErrorCode;
import lombok.Data;

@Data
public class CommonResponse<T> {
    private String code;

    private String message;

    private T data;

    public static <T> CommonResponse<T> success(T data) {
        CommonResponse<T> result = new CommonResponse<>();
        result.setCode(SuccessCode.SUCCESS.getCode());
        result.setMessage(SuccessCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> CommonResponse<T> success() {
        return success(null);
    }

    public static CommonResponse<Void> failed(String message) {
        CommonResponse<Void> result = new CommonResponse<>();
        result.setCode(ErrorCode.FAILED.getCode());
        result.setMessage(message);
        return result;
    }

    public static CommonResponse<Void> failed(ErrorCode errorCode) {
        CommonResponse<Void> result = new CommonResponse<>();
        result.setCode(errorCode.getCode());
        result.setMessage(errorCode.getMessage());
        return result;
    }

    public static CommonResponse<Void> failed(ErrorCode errorCode, String message) {
        CommonResponse<Void> result = new CommonResponse<>();
        result.setCode(errorCode.getCode());
        result.setMessage(message);
        return result;
    }
}
