package com.example.springtest.controller;

import com.example.springtest.dto.ProductRequest;
import com.example.springtest.dto.ProductResponse;
import com.example.springtest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest request){
        Long productId  = productService.save(request);
       return new ResponseEntity<>(productId, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("id") Long id){
        ProductResponse productResponse = productService.searchById(id);
        return  new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
}
