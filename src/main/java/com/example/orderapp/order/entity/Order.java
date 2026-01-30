package com.example.orderapp.order.entity;


import com.example.orderapp.product.domain.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public Order(Product product, int quantity, String buyerName) {
        this.product = product;
        this.quantity = quantity;
        this.buyerName = buyerName;
    }

}
