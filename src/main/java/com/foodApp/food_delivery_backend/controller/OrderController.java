package com.foodApp.food_delivery_backend.controller;

import com.foodApp.food_delivery_backend.dto.OrderResponse;
import com.foodApp.food_delivery_backend.service.OrderService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/checkout")
    public OrderResponse placeOrder(Authentication auth) {
        return orderService.placeOrder(auth.getName());
    }
}