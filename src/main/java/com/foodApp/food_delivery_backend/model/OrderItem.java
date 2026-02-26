package com.foodApp.food_delivery_backend.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "orderItems")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;

    private BigDecimal PriceAtPurchase;

    private Integer quantity;

    public OrderItem() {}

    public OrderItem(Integer id, Order order, MenuItem menuItem, BigDecimal PriceAtPurchase, Integer quantity) {
        this.id = id;
        this.order = order;
        this.menuItem = menuItem;
        this.PriceAtPurchase = PriceAtPurchase;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public MenuItem getMenuItem() {
        return menuItem;
    }
    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
    public BigDecimal getPriceAtPurchase() {
        return PriceAtPurchase;
    }
    public void setPriceAtPurchase(BigDecimal PriceAtPurchase) {
        this.PriceAtPurchase = PriceAtPurchase;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



}
