package org.vdoloka.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vdoloka.Service.OrdersService;
import org.vdoloka.entity.OrderEntity;
import org.vdoloka.repository.OrdersRepository;



@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService ordersService;
    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersController(OrdersService ordersService, OrdersRepository ordersRepository) {
        this.ordersService = ordersService;
        this.ordersRepository = ordersRepository;
    }


    @GetMapping("/")
    public Iterable<OrderEntity> getProducts() {
        return ordersRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<String> createOrder(OrderEntity orderEntity) {
        System.out.println(orderEntity);
        boolean success=ordersService.save(orderEntity);
        if (success){
        return new ResponseEntity<>(HttpStatus.CREATED);}
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body("Not enough money");
    }

}