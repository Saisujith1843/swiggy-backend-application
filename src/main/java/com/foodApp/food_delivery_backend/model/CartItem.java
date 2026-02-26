package com.foodApp.food_delivery_backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "cartItems")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItem menu_item;

    private Integer quantity;

    public CartItem() {}

    public CartItem(Cart cart, MenuItem menu_item, Integer quantity) {
        this.cart = cart;
        this.menu_item = menu_item;
        this.quantity = quantity;

    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public MenuItem getMenuItem() {
        return menu_item;
    }
    public void setMenuItem(MenuItem menu_item) {
        this.menu_item = menu_item;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }




}
