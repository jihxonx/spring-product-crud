package com.example.orderapp.order.service;

import com.example.orderapp.order.dto.OrderRequestDto;
import com.example.orderapp.order.entity.Order;
import com.example.orderapp.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(OrderRequestDto requestDto) {
        Order order = new Order(requestDto.getProductId(),
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
