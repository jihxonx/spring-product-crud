package com.example.orderapp.order.controller;

import com.example.orderapp.order.dto.OrderRequestDto;
import com.example.orderapp.order.entity.Order;
import com.example.orderapp.order.repository.OrderRepository;
import com.example.orderapp.order.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderRequestDto requestDto) {
        return orderService.createOrder(requestDto);
    }

    @GetMapping
    public Page<Order> getOrders(Pageable pageable) {
        return orderService.getOrder(pageable);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }
}
