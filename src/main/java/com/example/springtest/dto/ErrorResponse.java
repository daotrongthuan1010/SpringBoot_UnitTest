package com.example.springtest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

    @JsonProperty(namespace = "error_code")
    private String errorCode;

    @JsonProperty(namespace = "message")
    private String message;
}
