package com.microservice.order.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.microservice.order.request.OrderDetailRequestDto;
import com.microservice.order.request.OrderRequestDto;
import com.microservice.order.response.OrderDetailResponseDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="app_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 100, initialValue = 4)
    @Column(name = "id_order")
	private Integer idOrder;

    @Column(name = "username")
	private String username;

	@Column(name="order_date")
	private Timestamp orderDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetails;
	
	public Order() {
	}
	
	public Order(OrderRequestDto orderDto) {
		this.idOrder = orderDto.getIdOrder();
		this.username = orderDto.getUsername();
		this.orderDate = orderDto.getOrderDate();
		this.orderDetails = convertListOrderDetail(orderDto);
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

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	private Set<OrderDetail> convertListOrderDetail(OrderRequestDto orderDto) {
		OrderRequestDto orderDtoTemp = orderDto; 
		Set<OrderDetail> orderDetail = new HashSet<OrderDetail>();
		for(OrderDetailRequestDto orderDetailDto : orderDto.getOrderDetails()) {
			orderDetail.add(new OrderDetail(orderDetailDto));
		}
		return orderDetail;
	}
    
	
}
