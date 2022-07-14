package com.smitha.products.controller;

import com.smitha.products.entity.Product;
import com.smitha.products.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    Product mockProduct;

    @MockBean
    private ProductService productService;

    @BeforeEach
    void setUp() {
        mockProduct = Product.builder()
                .inventoryId(200L)
                .experienceDetails("You will be able to tour the entire park by taking this ride")
                .content("Tram ride")
                .stockLevel(50)
                .build();

    }

    @Test
    void testFetchProduct() throws Exception {
        Mockito.when(productService.fetchProduct(200L))
                .thenReturn(mockProduct);

        mockMvc.perform(MockMvcRequestBuilders.get("/products/200")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content")
                        .value(mockProduct.getContent()));

    }

    @Test
    void testBookProduct() throws Exception {
        Mockito.when(productService.fetchProduct(200L))
                .thenReturn(mockProduct);

        mockMvc.perform(MockMvcRequestBuilders.get("/products/book/200")
                        .contentType("Product booked successfully!"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }



}