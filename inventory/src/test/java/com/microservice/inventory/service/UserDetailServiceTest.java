package com.microservice.inventory.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import com.microservice.inventory.InventoryConstants;
import com.microservice.inventory.response.UserResponseDto;
import com.microservice.inventory.util.RestTemplateUtil;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserDetailServiceTest {
	@Autowired
	UserDetailService userDetailService;
	
	@MockBean
	RestTemplateUtil restTemplateUtil;
	
	@Test
	public void testLoadUserByUsername() {
		//INITIALIZE RESPONSE FROM SERVICE USER
		String urlFindById = InventoryConstants.User.HOST
				.concat(InventoryConstants.User.PORT)
				.concat(InventoryConstants.User.MAIN_PATH)
				.concat(InventoryConstants.User.FIND_BY_ID);
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
