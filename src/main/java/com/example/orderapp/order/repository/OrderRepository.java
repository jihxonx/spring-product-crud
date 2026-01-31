package com.example.orderapp.order.repository;

import com.example.orderapp.order.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

    /*'SELECT o FROM Order o' : Order 엔티티를 조회
    * 'JOIN FETCH o.product' : Order의 product도 함께 조회
    * JOIN FETCH -> N+1 문제 해결*/
    @Query("SELECT o FROM Order o join FETCH o.product")
    Page<Order> findAllWithProduct(Pageable pageable);
}
