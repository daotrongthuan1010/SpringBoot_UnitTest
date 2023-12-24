package com.example.springtest;

import com.example.springtest.dto.ProductResponse;
import com.example.springtest.entity.Product;
import com.example.springtest.repository.ProductRepository;
import com.example.springtest.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private  ProductService productService;


    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSearchById() {
        Product product = Product.builder()
                .id(1)
                .name("Samsung galaxy S1")
                .codeProduct("ThuanDT3_GALAXY_WHITE")
                .price(2000000)
                .quantity(100)
                .build();


        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        ProductResponse resultTest = productService.searchById(1L);

        assertEquals(product.getName(), resultTest.getName());
        assertEquals(product.getPrice(), resultTest.getPrice());

        verify(productRepository, times(1)).findById(1L);
        verifyNoMoreInteractions(productRepository);
    }
}
