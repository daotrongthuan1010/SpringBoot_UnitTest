package com.example.springtest.service.serviceIpm;

import com.example.springtest.dto.ProductRequest;
import com.example.springtest.dto.ProductResponse;
import com.example.springtest.entity.Product;
import com.example.springtest.exception.ProductException;
import com.example.springtest.repository.ProductRepository;
import com.example.springtest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceIpm implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse searchById(Long id) {

        Product product = productRepository.findById(id).orElseThrow(()-> new ProductException("PRODUCT_NOT_FOUND","NOT_FOUND"));

        return ProductResponse.builder()
                .codeProduct(product.getCodeProduct())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    @Override
    public Long save(ProductRequest productDTO) {

       Product product = productRepository.save(Product.builder()
                        .name(productDTO.getName())
                        .codeProduct(productDTO.getCodeProduct())
                        .price(productDTO.getPrice())
                        .quantity(productDTO.getQuantity())
                .build());

        return product.getId();
    }
}
