package com.microservice.order.request;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import com.microservice.order.entity.OrderDetail;
import com.microservice.order.response.OrderDetailResponseDto;

public class OrderRequestDto {
	private Integer idOrder;
	private String username;
	private Timestamp orderDate;
	private Set<OrderDetailRequestDto> orderDetails;
	
	public OrderRequestDto() {
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
	public Set<OrderDetailRequestDto> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Set<OrderDetailRequestDto> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
