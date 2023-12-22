package com.example.springtest.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductRequest {

    private String name;

    private double price;

    private long quantity;

    private String codeProduct;

}
