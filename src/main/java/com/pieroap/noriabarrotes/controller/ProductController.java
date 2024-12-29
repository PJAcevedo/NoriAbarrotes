package com.pieroap.noriabarrotes.controller;

import com.pieroap.noriabarrotes.dao.ProductRepository;
import com.pieroap.noriabarrotes.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}
