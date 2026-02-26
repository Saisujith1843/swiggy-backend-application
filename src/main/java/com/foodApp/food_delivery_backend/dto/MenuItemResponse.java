package com.foodApp.food_delivery_backend.dto;

import java.math.BigDecimal;

public class MenuItemResponse {

    private Integer id;
    private String name;
    private BigDecimal price;
    private boolean available;
    private String restaurantName;

    public MenuItemResponse() {}
    public MenuItemResponse(Integer id, String name, BigDecimal price, boolean available, String restaurantName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.available = available;
        this.restaurantName = restaurantName;
    }



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public String getRestaurantName() {
        return restaurantName;
    }
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

}
