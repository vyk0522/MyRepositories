package com.onejava.ecommerce.service;

import com.onejava.ecommerce.jpa.entity.Product;
import com.onejava.ecommerce.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
