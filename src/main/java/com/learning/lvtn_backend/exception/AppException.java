package com.learning.lvtn_backend.exception;

public class AppException extends RuntimeException {
    public AppException(String message) {
        super(message);
    }
}