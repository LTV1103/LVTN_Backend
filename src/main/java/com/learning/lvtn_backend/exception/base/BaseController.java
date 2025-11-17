package com.learning.lvtn_backend.exception.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    // Trả về ResponseEntity (status HTTP vẫn giữ, nhưng JSON không chứa status)
    protected <T> ResponseEntity<ApiResponse<T>> successResponse(HttpStatus status, String message, T data) {
        return ResponseEntity.status(status)
                .body(new ApiResponse<>(message, data));
    }

    // 200 OK
    protected <T> ResponseEntity<ApiResponse<T>> success(String message, T data) {
        return successResponse(HttpStatus.OK, message, data);
    }

    // 201 CREATED
    protected <T> ResponseEntity<ApiResponse<T>> created(String message, T data) {
        return successResponse(HttpStatus.CREATED, message, data);
    }

    // 204 NO CONTENT – không trả data luôn
    protected ResponseEntity<ApiResponse<Void>> deleted(String message) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(new ApiResponse<>(message, null));
    }

    // Error
    protected <T> ResponseEntity<ApiResponse<T>> error(HttpStatus status, String message, T data) {
        return ResponseEntity.status(status)
                .body(new ApiResponse<>(message, data));
    }
}
