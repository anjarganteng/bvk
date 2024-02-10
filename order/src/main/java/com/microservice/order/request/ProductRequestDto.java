package com.microservice.order.request;

import java.math.BigDecimal;

public class ProductRequestDto {
	private String productCode;
	private String productName;
	private BigDecimal price;
	private Integer quantity;
	
	public ProductRequestDto() {
	}

	public ProductRequestDto(String productCode, Integer quantity) {
		this.productCode = productCode;
		this.quantity = quantity;
	}
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
