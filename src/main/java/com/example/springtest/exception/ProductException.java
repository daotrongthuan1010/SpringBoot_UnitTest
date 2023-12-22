package com.example.springtest.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductException extends RuntimeException{

    private String errorCode;

    public ProductException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
