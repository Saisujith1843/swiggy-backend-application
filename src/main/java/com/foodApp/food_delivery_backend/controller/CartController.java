package com.foodApp.food_delivery_backend.controller;

import com.foodApp.food_delivery_backend.dto.CartItemRequest;
import com.foodApp.food_delivery_backend.dto.CartResponse;
import com.foodApp.food_delivery_backend.service.CartService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public void addToCart(Authentication auth,
                          @RequestBody @Valid CartItemRequest request) {
        cartService.addToCart(auth.getName(), request);
    }

    @GetMapping
    public CartResponse getCart(Authentication auth) {
        return cartService.getCart(auth.getName());
    }

    @DeleteMapping("/{menuItemId}")
    public void removeItem(Authentication auth,
                           @PathVariable Integer menuItemId) {
        cartService.removeFromCart(auth.getName(), menuItemId);
    }
}