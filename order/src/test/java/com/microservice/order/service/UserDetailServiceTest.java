package com.microservice.order.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import com.microservice.order.OrderConstants;
import com.microservice.order.response.UserResponseDto;
import com.microservice.order.util.RestTemplateUtil;

@SpringBootTest
public class UserDetailServiceTest {
	@Autowired
	UserDetailService userDetailService;
	
	@MockBean
	RestTemplateUtil restTemplateUtil;
	
	@Test
	public void testLoadUserByUsername() {
		//INITIALIZE RESPONSE FROM SERVICE USER
		String urlFindById = OrderConstants.User.HOST
				.concat(OrderConstants.User.PORT)
				.concat(OrderConstants.User.MAIN_PATH)
				.concat(OrderConstants.User.FIND_BY_ID);
		String username = "rey";
		UserResponseDto userRes = new UserResponseDto();
		userRes.setUsername("rey");
		userRes.setPassword("$2a$10$wPaWi3S4dkwqqPu5nDQCb.yEjnxwGObYDIYgTlNCno8ccwyhpaWXS");
		when(restTemplateUtil.postForObject(urlFindById, username, UserResponseDto.class))
			.thenReturn(userRes);
		//FIND USERNAME "rey"
		UserDetails userDetails = userDetailService.loadUserByUsername("rey");
		//USER "rey" IS NOT NULL
		assertThat(userDetails).isNotNull();
	}

}
