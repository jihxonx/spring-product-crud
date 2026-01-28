package com.example.orderapp.order.service;

import com.example.orderapp.domain.Product;
import com.example.orderapp.order.dto.OrderRequestDto;
import com.example.orderapp.order.entity.Order;
import com.example.orderapp.order.repository.OrderRepository;
import com.example.orderapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order createOrder(OrderRequestDto requestDto) {

        Product product = productRepository.findById(requestDto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));

        Order order = new Order(product,
                requestDto.getQuantity(),
                requestDto.getBuyerName());

        return orderRepository.save(order);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾지 못했습니다."));
    }

}
