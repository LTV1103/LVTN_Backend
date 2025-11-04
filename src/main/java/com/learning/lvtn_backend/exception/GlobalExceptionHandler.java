package com.learning.lvtn_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Xử lý các lỗi chung khi throw RuntimeException
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.badRequest().body(Map.of(
                "timestamp", LocalDateTime.now(),
                "status", HttpStatus.BAD_REQUEST.value(),
                "error", "Bad Request",
                "message", e.getMessage()
        ));
    }

    // Xử lý lỗi validate khi dùng @Valid trong DTO
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException e) {
        String message = (e.getFieldError() != null)
                ? e.getFieldError().getDefaultMessage()
                : "Dữ liệu không hợp lệ";

        return ResponseEntity.badRequest().body(Map.of(
                "timestamp", LocalDateTime.now(),
                "status", HttpStatus.BAD_REQUEST.value(),
                "error", "Validation Failed",
                "message", message
        ));
    }

//    // Xử lý các lỗi chưa được định nghĩa cụ thể (fallback)
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> handleGenericException(Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
//                "timestamp", LocalDateTime.now(),
//                "status", HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                "error", "Internal Server Error",
//                "message", e.getMessage()
//        ));
//    }
}
