package com.techzen.academy.exception;

import com.techzen.academy.model.Student;
import com.techzen.academy.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandleException {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handlingApiException(ApiException exception) {
        ErrorCode errorCode = exception.getErrorCode();

        return ResponseEntity.status(errorCode.getStatus()).body(ApiResponse.<Student>builder()
                                .code(errorCode.getCode())
                                .message(errorCode.getMessage())
                        .build());
    }
}
