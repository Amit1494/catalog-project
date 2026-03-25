package com.product.catalog.service;

import com.product.catalog.model.Product;
import com.product.catalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public List<Product> getProductByCategory(Long categoryId){
    return productRepository.findByCategoryId(categoryId);
    }


}
