package com.foodApp.food_delivery_backend.repository;

import com.foodApp.food_delivery_backend.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    List<Restaurant> findByOwnerUsername(String username);
}
