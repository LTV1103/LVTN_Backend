package com.learning.be_english_course.Exception.apiRespone;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    // Trả về ResponseEntity (status HTTP vẫn giữ, JSON có cả status)
    protected <T> ResponseEntity<ApiResponse<T>> successResponse(HttpStatus status, String message, T data) {
        return ResponseEntity.status(status)
                .body(new ApiResponse<>(status.value(), message, data));
    }

    // 200 OK
    protected <T> ResponseEntity<ApiResponse<T>> success(String message, T data) {
        return successResponse(HttpStatus.OK, message, data);
    }

    // 201 CREATED
    protected <T> ResponseEntity<ApiResponse<T>> created(String message, T data) {
        return successResponse(HttpStatus.CREATED, message, data);
    }

    // 204 NO CONTENT – không trả data
    protected ResponseEntity<ApiResponse<Void>> deleted(String message) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(new ApiResponse<>(HttpStatus.NO_CONTENT.value(), message, null));
    }
    // MISS DATA
    protected ResponseEntity<ApiResponse<Void>> missingData(String message) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), message, null));
    }

    // Error
    protected <T> ResponseEntity<ApiResponse<T>> error(HttpStatus status, String message, T data) {
        return ResponseEntity.status(status)
                .body(new ApiResponse<>(status.value(), message, data));
    }
}
