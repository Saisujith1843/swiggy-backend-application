package com.foodApp.food_delivery_backend.service;

import com.foodApp.food_delivery_backend.dto.MenuItemRequest;
import com.foodApp.food_delivery_backend.dto.MenuItemResponse;
import com.foodApp.food_delivery_backend.model.MenuItem;
import com.foodApp.food_delivery_backend.model.Restaurant;
import com.foodApp.food_delivery_backend.repository.MenuItemRepository;
import com.foodApp.food_delivery_backend.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;
    public MenuService(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public MenuItemResponse addItem(MenuItemRequest menuItemRequest) {
        Restaurant restaurant = restaurantRepository.findById(menuItemRequest.getRestaurantId())
                .orElseThrow(()-> new RuntimeException("Restaurant not found"));


        MenuItem item = new  MenuItem();
        item.setName(menuItemRequest.getName());
        item.setPrice(menuItemRequest.getPrice());
        item.setAvailable(menuItemRequest.isAvailable());
        item.setRestaurant(restaurant);

        menuItemRepository.save(item);

        return new MenuItemResponse(
                item.getId(),
                item.getName(),
                item.getPrice(),
                item.isAvailable(),
                restaurant.getName()
        );
    }

    public List<MenuItemResponse> getByRestaurant(Integer restaurantId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(()-> new RuntimeException("Restaurant not found"));


        return menuItemRepository.findByRestaurantId(restaurantId)
                .stream()
                .map(m -> new MenuItemResponse(
                        m.getId(),
                        m.getName(),
                        m.getPrice(),
                        m.isAvailable(),
                        restaurant.getName()))
                .toList();
    }
}

