package com.microservice.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
