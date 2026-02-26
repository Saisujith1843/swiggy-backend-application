package com.foodApp.food_delivery_backend.repository;

import com.foodApp.food_delivery_backend.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
    List<MenuItem> findByRestaurantId(Integer restaurantId);
}
