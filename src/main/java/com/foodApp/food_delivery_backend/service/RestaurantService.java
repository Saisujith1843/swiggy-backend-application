package com.foodApp.food_delivery_backend.service;

import com.foodApp.food_delivery_backend.dto.RestaurantRequest;
import com.foodApp.food_delivery_backend.dto.RestaurantResponse;
import com.foodApp.food_delivery_backend.model.Restaurant;
import com.foodApp.food_delivery_backend.model.User;
import com.foodApp.food_delivery_backend.repository.RestaurantRepository;
import com.foodApp.food_delivery_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    /*
    Create restaurant (only OWNER role)
    Get all restaurants
    Get owner restaurants
     */
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    public RestaurantResponse createRestaurant(RestaurantRequest restaurantRequest){

        User owner = userRepository.findByUsername(restaurantRequest.getName()).orElseThrow();

        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantRequest.getName());
        restaurant.setAddress(restaurantRequest.getAddress());
        restaurant.setOwner(owner);
        restaurantRepository.save(restaurant);

        return new RestaurantResponse(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getAddress(),
                restaurant.getOwner()
        );
    }

    public List<RestaurantResponse> getAllRestaurants(){
        return restaurantRepository.findAll()
                .stream()
                .map(r -> new RestaurantResponse(
                        r.getId(),
                        r.getName(),
                        r.getAddress(),
                        r.getOwner()))
                .toList();
    }


}
