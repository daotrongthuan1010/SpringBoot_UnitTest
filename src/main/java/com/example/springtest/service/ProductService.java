package com.example.springtest.service;



import com.example.springtest.dto.ProductRequest;
import com.example.springtest.dto.ProductResponse;

public interface ProductService {

    ProductResponse searchById(Long id);

    Long save(ProductRequest request);
}
