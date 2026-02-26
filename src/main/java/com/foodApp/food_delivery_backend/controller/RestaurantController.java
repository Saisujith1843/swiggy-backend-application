package com.foodApp.food_delivery_backend.controller;

import com.foodApp.food_delivery_backend.dto.RestaurantRequest;
import com.foodApp.food_delivery_backend.dto.RestaurantResponse;
import com.foodApp.food_delivery_backend.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public RestaurantResponse createRestaurant(@RequestBody @Valid RestaurantRequest request) {
        return restaurantService.createRestaurant(request);
    }

    @GetMapping
    public List<RestaurantResponse> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }
}