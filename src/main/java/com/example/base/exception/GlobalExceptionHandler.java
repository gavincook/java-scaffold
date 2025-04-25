package com.example.base.exception;

import com.example.base.api.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 未捕获的异常：500
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<CommonResponse<Void>> handleException(Throwable e) {
        log.error("Global exception handler caught an exception: ", e);
        return new ResponseEntity<>(CommonResponse.failed(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 业务异常，根据ErrorCode返回对应的HTTP状态码
    @ExceptionHandler(BizException.class)
    public ResponseEntity<CommonResponse<Void>> handleBizException(BizException e) {
        log.error("Business exception caught: ", e);
        return new ResponseEntity<>(CommonResponse.failed(e.getMessage()), e.getErrorCode().getHttpStatus());
    }
}
