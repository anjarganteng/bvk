package com.microservice.order.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.microservice.order.OrderConstants;
import com.microservice.order.OrderConstants.Message;
import com.microservice.order.entity.Order;
import com.microservice.order.entity.OrderDetail;
import com.microservice.order.repository.OrderDetailRepository;
import com.microservice.order.repository.OrderRepository;
import com.microservice.order.request.OrderDetailRequestDto;
import com.microservice.order.request.OrderRequestDto;
import com.microservice.order.request.ProductRequestDto;
import com.microservice.order.response.OrderDetailResponseDto;
import com.microservice.order.response.OrderResponseDto;
import com.microservice.order.util.RestTemplateUtil;

@Service
@Transactional
public class OrderService {
	private OrderRepository orderRepository;
	private OrderDetailRepository orderDetailRepository;
	private RestTemplateUtil restTemplateUtil;

	public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, RestTemplateUtil restTemplateUtil) {
		this.orderRepository = orderRepository;
		this.orderDetailRepository = orderDetailRepository;
		this.restTemplateUtil = restTemplateUtil;
	}

	public OrderResponseDto findById(Integer idOrder) {
		try {
			Order order = orderRepository.findById(idOrder).get();
			return new OrderResponseDto(order);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<OrderResponseDto> findAll() {
		List<Order> orders = orderRepository.findAll();
		List<OrderResponseDto> orderDtos = new ArrayList<OrderResponseDto>();
		for(Order order : orders) {
			orderDtos.add(new OrderResponseDto(order));
		}
		return orderDtos;
	}

	public String doOrder(OrderRequestDto orderDto) {
		try {
			if(validateOrder(orderDto)){ //CHECKING PRODUCT'S QUANTITY
				//CREATE ORDER
				Order order = initOrder(orderDto);
				orderRepository.save(order);
				//BULK UPDATE PRODUCT QUANTITY
				updateQuantityAllProduct(orderDto.getOrderDetails()); 
				return OrderConstants.Message.SUCCESS;
			} else {
				return OrderConstants.Message.PRODUCT_NOT_ENOUGH;
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	private Boolean validateOrder(OrderRequestDto orderDto) {
		Boolean isValidQty = true;
		for(OrderDetailRequestDto orderDetailDto : orderDto.getOrderDetails()) {
			Integer productQuantity = checkQuantity(orderDetailDto.getProductCode());
			if(productQuantity < orderDetailDto.getQuantity() ) { //CHECK QUANTITY PRODUCT
				isValidQty = false;
			}
		}
		return isValidQty;
	}
	
	private Order initOrder(OrderRequestDto orderDto) {
		Order order = new Order();
		order.setIdOrder(0);
		order.setOrderDate(orderDto.getOrderDate());
		order.setUsername(orderDto.getUsername());
		
		Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();
		for(OrderDetailRequestDto ord : orderDto.getOrderDetails()) {
			OrderDetail orderDetail = new OrderDetail(ord);
			orderDetail.setIdOrderDetail(0);
			orderDetail.setOrder(order);
			orderDetails.add(orderDetail);
		}
		
		order.setOrderDetails(orderDetails);		
		return order;
	}
	
	private Integer checkQuantity(String productCode) {
		String urlFindById = OrderConstants.Inventory.HOST
				.concat(OrderConstants.Inventory.PORT)
				.concat(OrderConstants.Inventory.MAIN_PATH)
				.concat(OrderConstants.Inventory.CHECK_QUANTITY);
		return restTemplateUtil.postForObject(urlFindById, productCode, Integer.class);
	}
	
	private void updateQuantityAllProduct(Set<OrderDetailRequestDto> orderDtos) throws Exception {
		//INITIALIZE CURRENT PRODUCT QUANTITY
		List<ProductRequestDto> productDtos = new ArrayList<ProductRequestDto>();
		for(OrderDetailRequestDto orderDto : orderDtos) {
			Integer currentProductQuantity = checkQuantity(orderDto.getProductCode()) - orderDto.getQuantity();
			ProductRequestDto productDto = new ProductRequestDto(orderDto.getProductCode(), currentProductQuantity); 
			productDtos.add(productDto);
		}
		//BULK UPDATE PRODUCT's QUANTITY
		String urlFindById = OrderConstants.Inventory.HOST
				.concat(OrderConstants.Inventory.PORT)
				.concat(OrderConstants.Inventory.MAIN_PATH)
				.concat(OrderConstants.Inventory.UPDATE_QUANTITY_MANY);
		
		ResponseEntity<String> response = restTemplateUtil.exchange(urlFindById, HttpMethod.POST, productDtos, String.class);
		if(response.getStatusCode().value() != 200) {
			throw new Exception(OrderConstants.Message.FAILED_UPDATE_PRODUCT);
		}
	}

}
