package com.microservice.order.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.microservice.order.response.OrderResponseDto;

@SpringBootTest
public class OrderServiceTest {
	@Autowired
	OrderService orderService;

	@Test
	public void testFindById() {
		//FIND ORDER ID 1
		OrderResponseDto orderDto = orderService.findById(1);
		//ORDER ID 1 IS NOT NULL
		assertThat(orderDto).isNotNull();
	}
	
	@Test
	public void testFindAll() {
		//FIND ALL ORDER
		List<OrderResponseDto> orderDtos = orderService.findAll();
		//ORDER IS NOT NULL
		//ORDER HAS SAMPLE ID 1,2,3
		assertThat(orderDtos)
				.isNotNull()
                .extracting(OrderResponseDto::getIdOrder)
				.contains(1, 2, 3);	
	}
}
