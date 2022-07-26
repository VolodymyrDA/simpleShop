package org.vdoloka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vdoloka.Service.OrdersService;
import org.vdoloka.entity.ProductEntity;
import org.vdoloka.repository.ProductsRepository;

import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductsController {
    private final ProductsRepository productsRepository;
    private final OrdersService ordersService;
    @Autowired
    public ProductsController(ProductsRepository productsRepository, OrdersService ordersService) {
        this.productsRepository = productsRepository;
        this.ordersService = ordersService;
    }
    @GetMapping
    public Iterable<ProductEntity> getProducts() {
        return productsRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<Void> createProduct(ProductEntity productEntity) {
        productsRepository.save(productEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<Optional<ProductEntity>> getProductById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(productsRepository.findById(id), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ProductEntity> updateProduct(ProductEntity productEntity) {
        productsRepository.save(productEntity);
        return new ResponseEntity<>(productEntity, HttpStatus.OK);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProductById(@PathVariable(value = "id") long id) {
        ordersService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/user/{id}")
    public Iterable<ProductEntity> getUsers(@PathVariable(value = "id") long id) {
        return productsRepository.findAllByUserId(id);
    }
}