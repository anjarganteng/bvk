package com.microservice.order.controller;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.order.OrderConstants;
import com.microservice.order.entity.Order;
import com.microservice.order.request.OrderRequestDto;
import com.microservice.order.response.OrderResponseDto;
import com.microservice.order.service.OrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(OrderConstants.Order.MAIN_PATH)
public class OrderController {
	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@SecurityRequirement(name = "Authorization")
	@PostMapping(value = OrderConstants.Order.FIND_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	private OrderResponseDto findById(@RequestBody Integer orderId){
		return orderService.findById(orderId);
	}

	@SecurityRequirement(name = "Authorization")
	@PostMapping(value = OrderConstants.Order.FIND_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
	private List<OrderResponseDto> findAll(){
		return orderService.findAll();
	}

	@SecurityRequirement(name = "Authorization")
	@PostMapping(value = OrderConstants.Order.DO_ORDER, produces = MediaType.APPLICATION_JSON_VALUE)
	private String doOrder(@RequestBody OrderRequestDto orderDto){
		return orderService.doOrder(orderDto);
	}	

}
