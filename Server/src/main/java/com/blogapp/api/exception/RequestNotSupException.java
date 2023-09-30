package com.blogapp.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.HttpRequestMethodNotSupportedException; // Import the correct exception

import com.blogapp.api.payloads.ApiResponse;

@RestControllerAdvice
public class RequestNotSupException {
    
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class) // Use the correct exception class
    public ResponseEntity<ApiResponse> requestMethodNotSupportedHandler(HttpRequestMethodNotSupportedException ex){
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<>(apiResponse, HttpStatus.METHOD_NOT_ALLOWED); // You should use METHOD_NOT_ALLOWED for this case
    }

    // You can define other exception handlers here if needed.
}
