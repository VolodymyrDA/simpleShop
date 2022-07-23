package org.vdoloka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vdoloka.entity.ProductEntity;
import org.vdoloka.repository.ProductsRepository;

@RestController
@RequestMapping("products")
public class ProductsController {
    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping("/")
    public Iterable<ProductEntity> getProducts() {
        return productsRepository.findAll();
    }

}