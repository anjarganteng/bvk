package com.microservice.order.entity;

import java.math.BigDecimal;

import com.microservice.order.request.OrderDetailRequestDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="app_order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_detail_seq")
    @SequenceGenerator(name = "order_detail_seq", sequenceName = "order_detail_seq", allocationSize = 100, initialValue = 7)
	@Column(name = "id_order_detail")
	private Integer idOrderDetail;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order", nullable = true)
	private Order order;

    @Column(name = "product_code")
	private String productCode;

    @Column(name = "quantity")
	private Integer quantity;

    @Column(name = "price")
	private BigDecimal price;

    @Column(name = "discount")
	private BigDecimal discount;

    @Column(name = "total_amount")
	private BigDecimal totalAmount;

	public OrderDetail() {
	}
	
	public OrderDetail(OrderDetailRequestDto orderDto) {
		this.idOrderDetail = orderDto.getIdOrderDetail();
		this.productCode = orderDto.getProductCode();
		this.quantity = orderDto.getQuantity();
		this.price = orderDto.getPrice();
		this.discount = orderDto.getDiscount();
		this.totalAmount = orderDto.getTotalAmount();
	}
	
	public Integer getIdOrderDetail() {
		return idOrderDetail;
	}

	public void setIdOrderDetail(Integer idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
    
}
