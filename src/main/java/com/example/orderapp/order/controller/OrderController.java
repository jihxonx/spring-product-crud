package com.example.orderapp.order.controller;

import com.example.orderapp.order.entity.Order;
import com.example.orderapp.order.repository.OrderRepository;
import com.example.orderapp.order.service.OrderService;
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
    public Order createOrder(@RequestParam Long productId,
                             @RequestParam int quantity,
                             @RequestParam String buyerName) {

        return orderService.createOrder(productId, quantity, buyerName);
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }
}
