package com.smitha.products.service;

import com.smitha.products.entity.Product;
import com.smitha.products.error.ProductNotFoundException;
import com.smitha.products.repository.IProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private IProductRepository productRepo;

    @BeforeEach
    void setUp() {
        Product mockProduct = Product.builder()
                .inventoryId(200L)
                .experienceDetails("You will be able to tour the entire park by taking this ride")
                .content("Tram ride")
                .build();

        Mockito.when(productRepo.findById(200L))
                .thenReturn(Optional.ofNullable(mockProduct));

    }

    @Test
    @DisplayName("Get product based on valid product id")
    public void whenValidProductId_thenProductShouldBeFound() throws ProductNotFoundException {
        String content = "Tram ride";
        Long id = 200L;

        Product productFound = productService.fetchProduct(id);
        assertEquals(content, productFound.getContent());
    }

}