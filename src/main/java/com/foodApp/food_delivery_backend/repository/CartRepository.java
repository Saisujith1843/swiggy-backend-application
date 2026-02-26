package com.foodApp.food_delivery_backend.repository;

import com.foodApp.food_delivery_backend.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    Optional<Cart> findByUserUsername(String username);
}
