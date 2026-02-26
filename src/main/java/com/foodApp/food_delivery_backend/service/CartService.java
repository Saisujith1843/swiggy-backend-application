package com.foodApp.food_delivery_backend.service;

import com.foodApp.food_delivery_backend.dto.CartItemRequest;
import com.foodApp.food_delivery_backend.dto.CartItemResponse;
import com.foodApp.food_delivery_backend.dto.CartResponse;
import com.foodApp.food_delivery_backend.model.Cart;
import com.foodApp.food_delivery_backend.model.CartItem;
import com.foodApp.food_delivery_backend.model.MenuItem;
import com.foodApp.food_delivery_backend.repository.CartRepository;
import com.foodApp.food_delivery_backend.repository.MenuItemRepository;
import com.foodApp.food_delivery_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepo;
    private final MenuItemRepository menuRepo;
    private final UserRepository userRepo;

    public CartService(CartRepository cartRepo,
                       MenuItemRepository menuRepo,
                       UserRepository userRepo) {
        this.cartRepo = cartRepo;
        this.menuRepo = menuRepo;
        this.userRepo = userRepo;
    }

    public void addToCart(String username, CartItemRequest request) {

        Cart cart = cartRepo.findByUserUsername(username)
                .orElseGet(() -> {
                    Cart c = new Cart();
                    c.setUser(userRepo.findByUsername(username).orElseThrow());
                    return cartRepo.save(c);
                });

        MenuItem item = menuRepo.findById(request.getMenuItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setMenuItem(item);
        cartItem.setQuantity(request.getQuantity());

        cart.getItems().add(cartItem);
        cartRepo.save(cart);
    }

    public CartResponse getCart(String username) {

        Cart cart = cartRepo.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("Cart empty"));

        List<CartItemResponse> items = cart.getItems().stream()
                .map(i -> new CartItemResponse(
                        i.getMenuItem().getName(),
                        i.getQuantity(),
                        i.getMenuItem().getPrice()))
                .toList();

        BigDecimal total = items.stream()
                .map(i -> i.getPrice().multiply(BigDecimal.valueOf(i.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new CartResponse(items, total);
    }

    public void removeFromCart(String username, Integer menuItemId) {

        Cart cart = cartRepo.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        boolean removed = cart.getItems().removeIf(
                item -> item.getMenuItem().getId().equals(menuItemId)
        );

        if (!removed) {
            throw new RuntimeException("Item not present in cart");
        }

        cartRepo.save(cart);
    }

}
