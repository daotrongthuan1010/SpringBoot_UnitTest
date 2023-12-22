package com.example.springtest;

import com.example.springtest.entity.Product;
import com.example.springtest.repository.ProductRepository;
import com.example.springtest.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductRepositoryTest {

    @MockBean
    private ProductRepository productRepository;


    public ProductRepositoryTest() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Test product repository")
    @Test
    public void checkProductRepository(){

        Product product = createProductMock();
            when(productRepository.findById(1L)).thenReturn(Optional.of(product));

            Optional<Product> productTest= productRepository.findById(1L);

            Assertions.assertEquals(Optional.of(product), productTest);
            verify(productRepository, times(1)).findById(1L);

        }

    private Product createProductMock() {
        return Product.builder()
                .id(1)
                .name("Samsung galaxy S1")
                .codeProduct("ThuanDT3_GALAXY_WHITE")
                .price(2000000)
                .quantity(100)
                .build();
    }

}
