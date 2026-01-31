package com.example.orderapp.order.service;

import com.example.orderapp.product.domain.Product;
import com.example.orderapp.order.dto.OrderRequestDto;
import com.example.orderapp.order.entity.Order;
import com.example.orderapp.order.repository.OrderRepository;
import com.example.orderapp.product.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //트랙젝션 관리 어노테이션 (읽기 전용)
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Order createOrder(OrderRequestDto requestDto) {

        Product product = productRepository.findById(requestDto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));

        Order order = new Order(product,
                requestDto.getQuantity(),
                requestDto.getBuyerName());

        return orderRepository.save(order);
    }

    /*List -> Page : 전체가 아닌 페이지 단위로 조회*/
    public Page<Order> getOrder(Pageable pageable) {
        return orderRepository.findAllWithProduct(pageable);
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("주문을 찾지 못했습니다."));
    }

}
