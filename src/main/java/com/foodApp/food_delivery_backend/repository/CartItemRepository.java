package com.foodApp.food_delivery_backend.repository;

import com.foodApp.food_delivery_backend.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
