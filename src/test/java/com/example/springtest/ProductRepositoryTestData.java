package com.example.springtest;

import com.example.springtest.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTestData {



    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testQueryError() {
        long nonExistentId = 9999L;
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            productRepository.findById(nonExistentId)
                    .orElseThrow(() -> new EmptyResultDataAccessException(1));
        });
    }
}
