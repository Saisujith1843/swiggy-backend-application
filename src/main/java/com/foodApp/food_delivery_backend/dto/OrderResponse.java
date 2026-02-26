package com.foodApp.food_delivery_backend.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderResponse {

    private Integer orderId;
    private String status;
    private BigDecimal total;
    private List<OrderItemResponse> items;

    public OrderResponse(Integer orderId, String status,
                         BigDecimal total) {
        this.orderId = orderId;
        this.status = status;
        this.total = total;
    }

    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public List<OrderItemResponse> getItems() {
        return items;
    }
    public void setItems(List<OrderItemResponse> items) {
        this.items = items;
    }


}
