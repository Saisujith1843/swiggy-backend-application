package com.foodApp.food_delivery_backend.dto;

import jakarta.validation.constraints.NotBlank;

public class RestaurantRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String address;

    public RestaurantRequest() {}

    public RestaurantRequest(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
