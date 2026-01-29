package com.example.orderapp.order.entity;


import com.example.orderapp.product.domain.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

//    private Long productId;

    private int quantity;

    private String buyerName;

    protected Order() {

    }

    public Order(Product product, int quantity, String buyerName) {
        this.product = product;
        this.quantity = quantity;
        this.buyerName = buyerName;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getBuyerName() {
        return buyerName;
    }
}
