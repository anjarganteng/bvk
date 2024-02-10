package com.microservice.inventory.response;

import java.math.BigDecimal;

import com.microservice.inventory.entity.Product;

public class ProductResponseDto {
	private String productCode;
	private String productName;
	private BigDecimal price;
	private Integer quantity;
	
	public ProductResponseDto() {
	}

	public ProductResponseDto(Product product) {
		this.productCode = product.getProductCode();
		this.productName = product.getProductName();
		this.price = product.getPrice();
		this.quantity = product.getQuantity();
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
