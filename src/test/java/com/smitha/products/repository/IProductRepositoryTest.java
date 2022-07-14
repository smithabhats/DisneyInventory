package com.smitha.products.repository;

import com.smitha.products.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IProductRepositoryTest {

    @Autowired
    private IProductRepository productRepo;

    @Autowired
    private TestEntityManager entityMgr;

    @BeforeEach
    void setUp() {
        Product mockProduct = Product.builder()
                .experienceDetails("You will be able to tour the entire park by taking this ride")
                .content("Tram ride")
                .build();

        entityMgr.persist(mockProduct);
    }

    @Test
    public void whenFindById_thenReturnProduct(){
        Product product = productRepo.findById(1L).get();

        assertEquals(product.getContent(), "Tram ride");
    }
}