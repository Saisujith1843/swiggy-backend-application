package com.foodApp.food_delivery_backend.controller;

import com.foodApp.food_delivery_backend.dto.MenuItemRequest;
import com.foodApp.food_delivery_backend.dto.MenuItemResponse;
import com.foodApp.food_delivery_backend.service.MenuService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/{restaurantId}")
    public MenuItemResponse addItem(@RequestBody @Valid MenuItemRequest request) {
        return menuService.addItem(request);
    }

    @GetMapping("/{restaurantId}")
    public List<MenuItemResponse> getMenu(@PathVariable Integer restaurantId) {
        return menuService.getByRestaurant(restaurantId);
    }
}