package com.learning.lvtn_backend.exception.base;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public abstract class BaseController {

    //Trả về ResponseEntity<ApiResponse<T>> khi thành công
    protected <T> ResponseEntity<ApiResponse<T>> successResponse(int status, String message, T data) {
        return ResponseEntity.status(status)
                .body(new ApiResponse<>(status, message, data, LocalDateTime.now()));
    }

    //Shortcut cho status = 200
    protected <T> ResponseEntity<ApiResponse<T>> success(String message, T data) {
        return successResponse(200, message, data);
    }

    //Shortcut cho status = 201
    protected <T> ResponseEntity<ApiResponse<T>> created(String message, T data) {
        return successResponse(201, message, data);
    }

    //Shortcut cho status = 204 (no content)
    protected <T> ResponseEntity<ApiResponse<T>> deleted(String message, T data) {
        return successResponse(204, message, data);
    }
    protected <T> ResponseEntity<ApiResponse<T>> error(HttpStatus status, String message, T data) {
        return ResponseEntity.status(status)
                .body(new ApiResponse<>(
                        status.value(),
                        message,
                        data,
                        LocalDateTime.now()
                ));
    }

}
