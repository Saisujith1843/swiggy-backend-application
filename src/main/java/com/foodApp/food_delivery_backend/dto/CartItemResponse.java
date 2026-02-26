package com.foodApp.food_delivery_backend.dto;

import java.math.BigDecimal;

public class CartItemResponse {

    private String itemName;
    private Integer quantity;
    private BigDecimal price;

    public CartItemResponse() {}
    public CartItemResponse(String itemName, Integer quantity, BigDecimal price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}
