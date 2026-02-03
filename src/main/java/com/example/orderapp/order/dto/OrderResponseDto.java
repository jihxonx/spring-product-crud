package com.example.orderapp.order.dto;


import com.example.orderapp.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {

    private Long orderId;
    private Long productId;
    private String productName;
    private int productPrice;
    private int quantity;
    private String buyerName;

    public OrderResponseDto(Order order) {
        this.orderId = order.getId();
        this.productId = order.getProduct().getId();
        this.productName = order.getProduct().getName();
        this.productPrice = order.getProduct().getPrice();
        this.quantity = order.getQuantity();
        this.buyerName = order.getBuyerName();



    }
}
