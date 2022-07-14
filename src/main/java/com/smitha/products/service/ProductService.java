package com.smitha.products.service;

import com.smitha.products.entity.Product;
import com.smitha.products.error.InsufficientProductStockException;
import com.smitha.products.error.ProductNotFoundException;
import com.smitha.products.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepo;

    @Override
    public List<Product> fetchAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product fetchProduct(Long id) throws ProductNotFoundException {

        return productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found!"));
    }

    @Override
    public String bookProductWithId(Long id) throws ProductNotFoundException, InsufficientProductStockException {
        Product prod =  productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found!"));

        if(prod.getStockLevel() > 0){
            prod.setStockLevel(prod.getStockLevel()-1);
            productRepo.save(prod);
            return "Product booked successfully!";
        }else
            throw new InsufficientProductStockException("Sorry, product is not available for booking");
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

}
