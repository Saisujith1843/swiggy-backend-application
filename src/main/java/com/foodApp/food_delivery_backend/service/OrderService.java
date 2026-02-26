package com.foodApp.food_delivery_backend.service;

import com.foodApp.food_delivery_backend.dto.OrderResponse;
import com.foodApp.food_delivery_backend.model.*;
import com.foodApp.food_delivery_backend.repository.CartRepository;
import com.foodApp.food_delivery_backend.repository.OrderRepository;
import com.foodApp.food_delivery_backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class OrderService {

    private final CartRepository cartRepo;
    private final OrderRepository orderRepo;
    private final UserRepository userRepo;

    public OrderService(CartRepository cartRepo,
                        OrderRepository orderRepo,
                        UserRepository userRepo) {
        this.cartRepo = cartRepo;
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
    }

    @Transactional
    public OrderResponse placeOrder(String username) {

        User user = userRepo.findByUsername(username).orElseThrow();

        Cart cart = cartRepo.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("Cart empty"));

        Order order = new Order();
        order.setUser(user);
        order.setOrderStatus(OrderStatus.CREATED);
        order.setCreatedAt(new Date());

        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (CartItem c : cart.getItems()) {

            OrderItem oi = new OrderItem();
            oi.setOrder(order);
            oi.setMenuItem(c.getMenuItem());
            oi.setQuantity(c.getQuantity());
            oi.setPriceAtPurchase(c.getMenuItem().getPrice());

            BigDecimal itemTotal = oi.getPriceAtPurchase()
                    .multiply(BigDecimal.valueOf(oi.getQuantity()));

            total = total.add(itemTotal);

            orderItems.add(oi);
        }

        order.setItems(orderItems);
        order.setTotalAmount(total);

        cart.getItems().clear();

        orderRepo.save(order);

        return new OrderResponse(order.getId(), order.getOrderStatus().name(), total);
    }
}
