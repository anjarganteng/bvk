package com.microservice.inventory.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.microservice.inventory.request.ProductRequestDto;
import com.microservice.inventory.response.ProductResponseDto;

@SpringBootTest
public class ProductServiceTest {
	
	@Autowired
	private ProductService productService;

	@Test
	public void testFindById() {
		//FIND PRODUCT CODE S000001
		ProductResponseDto productDto = productService.findById("S000001");
		//PRODUCT CODE S000001 IS NOT NULL
		assertThat(productDto).isNotNull();
	}
	
	@Test
	public void testFindAll() {
		//FIND ALL PRODUCT
		List<ProductResponseDto> productDtos = productService.findAll();
		//PRODUCT IS NOT NULL 
		//PRODUCT HAS 3 SAMPLE DATA "I000001", "I000001", "S000001"
		assertThat(productDtos)
				.isNotNull()
                .extracting(ProductResponseDto::getProductCode)
				.contains("I000001", "I000001", "S000001");	
	}
	
	@Test
	public void testSave() {
		//INIT PRODUCT INSERT/UPDATE
		ProductRequestDto saveProductDto = new ProductRequestDto();
		saveProductDto.setProductCode("P000001");
		saveProductDto.setProductName("Product Test 1");
		saveProductDto.setQuantity(10);
		saveProductDto.setPrice(new BigDecimal(1000000));
		//SAVE PRODUCT
		productService.save(saveProductDto);
		//FIND SAVED PRODUCT
		ProductResponseDto findProductDto = productService.findById(saveProductDto.getProductCode());
		//CHECK SAVED PRODUCT IS NOT NULL
		assertThat(findProductDto)
				.isNotNull();
		//CHECK SAVED PRODUCT MATCH
        assertThat(findProductDto.getProductCode())
        		.isEqualTo(saveProductDto.getProductCode());
	}
	
	@Test
	public void testUpdateQuantity() {
		//INIT PRODUCT QUANTITY
		ProductRequestDto updateQtyProductDto = new ProductRequestDto();
		updateQtyProductDto.setProductCode("S000001");
		updateQtyProductDto.setQuantity(100);
		//SAVE PRODUCT QUANTITY
		productService.updateQuantity(updateQtyProductDto);
		//FIND SAVED PRODUCT QUANTITY
		ProductResponseDto findProductDto = productService.findById(updateQtyProductDto.getProductCode());
		//CHECK PRODUCT IS NOT NULL
		assertThat(findProductDto)
				.isNotNull();
		//CHECK SAVED PRODUCT QUANTITY MATCH
        assertThat(findProductDto.getQuantity())
        		.isEqualTo(updateQtyProductDto.getQuantity());
	}
	
	@Test
	public void testCheckQuantity() {
		//CHECK PRODUCT QUANTITY
		String productCode = "S000001";
		Integer quantity = productService.checkQuantity(productCode);
		//CHECK PRODUCT QUANTITY GREATER THAN 0
		assertTrue(quantity > 0);
	}
	

}
