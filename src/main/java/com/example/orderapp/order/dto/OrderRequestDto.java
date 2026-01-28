package com.example.orderapp.order.dto;

public class OrderRequestDto {
    private Long productId;
    private int quantity;
    private String buyerName;

    public OrderRequestDto() {

    }

    public OrderRequestDto(Long productId, int quantity, String buyerName) {
        this.productId = productId;
        this.quantity = quantity;
        this.buyerName = buyerName;
    }

    public Long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getBuyerName() {
        return buyerName;
    }
}
