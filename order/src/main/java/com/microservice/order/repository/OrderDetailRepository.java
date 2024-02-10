package com.microservice.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservice.order.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
	
}
