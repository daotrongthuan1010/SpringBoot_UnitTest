package com.example.springtest.exception;


import com.example.springtest.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorResponse> handlerProductException(ProductException exception){
        return new ResponseEntity<>(ErrorResponse.builder().errorCode(exception.getErrorCode())
                .message(exception.getMessage())
                .build(), HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value()));
    }
}
