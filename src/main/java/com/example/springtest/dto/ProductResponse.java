package com.example.springtest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductResponse {

    @JsonProperty(namespace = "name_product")
    private final String name;

    @JsonProperty(namespace = "price_product")
    private final double price;

    @JsonProperty(namespace = "quantity")
    private final long quantity;

    @JsonProperty(namespace = "code_product")
    private final String codeProduct;
}
