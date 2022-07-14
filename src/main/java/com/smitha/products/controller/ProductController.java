package com.smitha.products.controller;

import com.smitha.products.entity.Product;
import com.smitha.products.error.InsufficientProductStockException;
import com.smitha.products.error.ProductNotFoundException;
import com.smitha.products.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class ProductController {

    @Autowired
    IProductService productService;

    @PostMapping("/products")
    public Product saveProduct(@Valid @RequestBody Product product){
        log.info("Logging example. In saveProduct() of Product controller");
       return productService.saveProduct(product);
    }

   @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
       productService.deleteProduct(id);
        return "Deleted successfully";
    }

    @GetMapping("/products")
    public List<Product> fetchProducts(){
        log.info("Entering ProductController.fetchProducts()");
        return productService.fetchAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product fetchProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        log.info("Entering ProductController.fetchProductById()");
        return productService.fetchProduct(id);
    }

    @GetMapping("/products/book/{id}")
    public String bookProductWithId(@PathVariable("id") Long id)
            throws ProductNotFoundException, InsufficientProductStockException {
        log.info("Entering ProductController.bookProductWithId()");
        return productService.bookProductWithId(id);
    }

}
