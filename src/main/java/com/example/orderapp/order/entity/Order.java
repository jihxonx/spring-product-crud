package com.example.orderapp.order.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private int quantity;

    private String buyerName;

    protected Order() {

    }

    public Order(Long productId, int quantity, String buyerName) {
        this.productId = productId;
        this.quantity = quantity;
        this.buyerName = buyerName;
    }

    public Long getId() {
        return id;
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
