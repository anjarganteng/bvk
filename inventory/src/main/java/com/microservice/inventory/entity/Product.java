package com.microservice.inventory.entity;

import java.math.BigDecimal;
import com.microservice.inventory.request.ProductRequestDto;
import com.microservice.inventory.response.ProductResponseDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="app_product")
public class Product {
	
	@Id
	@Column(name="product_code")
	private String productCode;

	@Column(name="product_name")
	private String productName;

	@Column(name="price")
	private BigDecimal price;

	@Column(name="quantity")
	private Integer quantity;
	
	public Product() {
	}
	
	public Product(ProductRequestDto productDto) {
		this.productCode = productDto.getProductCode();
		this.productName = productDto.getProductName();
		this.price = productDto.getPrice();
		this.quantity = productDto.getQuantity();
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
