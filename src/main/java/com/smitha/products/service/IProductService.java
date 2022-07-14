package com.smitha.products.service;

import com.smitha.products.entity.Product;
import com.smitha.products.error.InsufficientProductStockException;
import com.smitha.products.error.ProductNotFoundException;

import java.util.List;

public interface IProductService {

    List<Product> fetchAllProducts();

    Product fetchProduct(Long id) throws ProductNotFoundException;


    String bookProductWithId(Long id)
            throws ProductNotFoundException, InsufficientProductStockException;

    Product saveProduct(Product product);

    void deleteProduct(Long id);

}
