package com.example.base.api.response;

import lombok.Data;

@Data
public class CommonResponse<T> {
    private CommonResponseCode code;

    private String message;

    private T data;

    public static <T> CommonResponse<T> success(T data) {
        CommonResponse<T> result = new CommonResponse<>();
        result.setCode(CommonResponseCode.SUCCESS);
        result.setMessage(CommonResponseCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> CommonResponse<T> success() {
        return success(null);
    }
}
