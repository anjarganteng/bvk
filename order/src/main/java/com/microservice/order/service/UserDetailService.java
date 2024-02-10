package com.microservice.order.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.order.OrderConstants;
import com.microservice.order.response.UserResponseDto;
import com.microservice.order.util.RestTemplateUtil;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserDetailService implements UserDetailsService {
	private RestTemplateUtil restTemplateUtil;
	
	public UserDetailService(RestTemplateUtil restTemplateUtil) {
		this.restTemplateUtil = restTemplateUtil;
	}

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	UserResponseDto userDto = userFindById(username);
		List<String> roles = new ArrayList<String>();
        roles.add("USER");
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(userDto.getUsername())
                        .password(userDto.getPassword())
                        .roles(roles.toArray(new String[0]))
                        .build();
        return userDetails;
    }

	private UserResponseDto userFindById(String username) {
		String urlFindById = OrderConstants.User.HOST
				.concat(OrderConstants.User.PORT)
				.concat(OrderConstants.User.MAIN_PATH)
				.concat(OrderConstants.User.FIND_BY_ID);
		UserResponseDto dto = restTemplateUtil.postForObject(urlFindById, username, UserResponseDto.class);
		return dto;
	}
    
}
