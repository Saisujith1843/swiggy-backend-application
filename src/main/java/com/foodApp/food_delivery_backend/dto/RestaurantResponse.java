package com.foodApp.food_delivery_backend.dto;

import com.foodApp.food_delivery_backend.model.User;

public class RestaurantResponse {

    private Integer Id;
    private String name;
    private String address;
    private User owner;

    public RestaurantResponse() {}
    public RestaurantResponse(Integer Id, String name, String address, User owner) {
        this.Id = Id;
        this.name = name;
        this.address = address;
        this.owner = owner;
    }


    public Integer getId() {
        return Id;
    }
    public void setId(Integer Id) {
        this.Id = Id;
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
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }

}
