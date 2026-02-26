package com.foodApp.food_delivery_backend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CartRequest {

    @NotNull
    private Integer menuItemId;
    @NotNull @Positive
    private Integer quantity;

    public CartRequest() {}
    public CartRequest(Integer menuItemId, Integer quantity) {
        this.menuItemId = menuItemId;
        this.quantity = quantity;
    }
    public Integer getMenuItemId() {
        return menuItemId;
    }
    public void setMenuItemId(Integer menuItemId) {
        this.menuItemId = menuItemId;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
