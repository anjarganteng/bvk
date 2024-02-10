package com.microservice.order.response;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.microservice.order.entity.Order;
import com.microservice.order.entity.OrderDetail;

public class OrderResponseDto {
	private Integer idOrder;
	private String username;
	private Timestamp orderDate;
	private Set<OrderDetailResponseDto> orderDetails;

	public OrderResponseDto() {
	}
	
	public OrderResponseDto(Order order) {
		this.idOrder = order.getIdOrder();
		this.username = order.getUsername();
		this.orderDate = order.getOrderDate();
		this.orderDetails = convertListOrderDetail(order);
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Set<OrderDetailResponseDto> getOrderDetails() {
		return orderDetails;
	}
	
	public void setOrderDetails(Set<OrderDetailResponseDto> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	private Set<OrderDetailResponseDto> convertListOrderDetail(Order order) {
		Set<OrderDetailResponseDto> orderDetailDtos = new HashSet<OrderDetailResponseDto>();
		for(OrderDetail orderDetail : order.getOrderDetails()) {
			orderDetailDtos.add(new OrderDetailResponseDto(orderDetail));
		}
		return orderDetailDtos;
	}
	
}
