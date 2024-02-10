package com.microservice.inventory.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.inventory.InventoryConstants;
import com.microservice.inventory.request.ProductRequestDto;
import com.microservice.inventory.response.ProductResponseDto;
import com.microservice.inventory.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(InventoryConstants.Inventory.MAIN_PATH)
public class ProductController {
	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@SecurityRequirement(name = "Authorization")
	@PostMapping(value = InventoryConstants.Inventory.ADD, produces = MediaType.APPLICATION_JSON_VALUE)
	private void save(@RequestBody ProductRequestDto productDto){
		productService.save(productDto);
	}
	
	@SecurityRequirement(name = "Authorization")
	@PostMapping(value = InventoryConstants.Inventory.FIND_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	private ProductResponseDto findById(@RequestBody String productCode){
		return productService.findById(productCode);
	}

	@SecurityRequirement(name = "Authorization")
	@PostMapping(value = InventoryConstants.Inventory.FIND_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
	private List<ProductResponseDto> findAll(){
		return productService.findAll();
	}

	@SecurityRequirement(name = "Authorization")
	@PostMapping(value = InventoryConstants.Inventory.UPDATE, produces = MediaType.APPLICATION_JSON_VALUE)
	private void update(@RequestBody ProductRequestDto productDto){
		productService.save(productDto);
	}
	
	@SecurityRequirement(name = "Authorization")
	@PostMapping(value = InventoryConstants.Inventory.UPDATE_QUANTITY, produces = MediaType.APPLICATION_JSON_VALUE)
	private void updateQuantity(@RequestBody ProductRequestDto productDto){
		productService.updateQuantity(productDto);
	}
	
	@SecurityRequirement(name = "Authorization")
	@PostMapping(value = InventoryConstants.Inventory.UPDATE_QUANTITY_MANY, produces = MediaType.APPLICATION_JSON_VALUE)
	private void updateQuantityMany(@RequestBody List<ProductRequestDto> productDtos){
		productService.updateQuantityMany(productDtos);
	}
	
	@SecurityRequirement(name = "Authorization")
	@PostMapping(value = InventoryConstants.Inventory.CHECK_QUANTITY, produces = MediaType.APPLICATION_JSON_VALUE)
	private Integer checkQuantity(@RequestBody String productCode){
		return productService.checkQuantity(productCode);
	}
	
}
