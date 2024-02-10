package com.microservice.inventory.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.microservice.inventory.entity.Product;
import com.microservice.inventory.repository.ProductRepository;
import com.microservice.inventory.request.ProductRequestDto;
import com.microservice.inventory.response.ProductResponseDto;

@Service
@Transactional
public class ProductService {	
	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public ProductResponseDto findById(String productCode) {
		try {
			Product product = productRepository.findById(productCode).get();
			return new ProductResponseDto(product);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<ProductResponseDto> findAll() {		
		List<Product> products = productRepository.findAll();
		List<ProductResponseDto> productDtos = new ArrayList<ProductResponseDto>();
		for(Product product : products) {
			productDtos.add(new ProductResponseDto(product));
		}
		return productDtos;
	}
	
	public void save(ProductRequestDto productDto) {
		Product product = new Product(productDto);
		productRepository.save(product);		
	}
	
	public void updateQuantity(ProductRequestDto productDto) {
		Product product = productRepository.findById(productDto.getProductCode()).get();
		product.setQuantity(productDto.getQuantity());
		productRepository.save(product);		
	}
	
	public void updateQuantityMany(List<ProductRequestDto> productDtos) {
		for(ProductRequestDto productDto : productDtos) {
			Product product = productRepository.findById(productDto.getProductCode()).get();
			product.setQuantity(productDto.getQuantity());
			productRepository.save(product);
		}
	}
	
	public Integer checkQuantity(String productCode) {
		Product product = productRepository.findById(productCode).get();
		return product.getQuantity();
	}
	
}
