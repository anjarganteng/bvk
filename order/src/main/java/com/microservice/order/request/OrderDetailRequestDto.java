package com.microservice.order.request;

import java.math.BigDecimal;

public class OrderDetailRequestDto {
	private Integer idOrderDetail;
	private Integer idOrder;
	private String productCode;
	private Integer quantity;
	private BigDecimal price;
	private BigDecimal discount;
	private BigDecimal totalAmount;
	
	public OrderDetailRequestDto() {
	}
	
	public Integer getIdOrderDetail() {
		return idOrderDetail;
	}
	public void setIdOrderDetail(Integer idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
	}	
	public Integer getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
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
