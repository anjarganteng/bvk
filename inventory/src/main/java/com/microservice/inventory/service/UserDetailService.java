package com.microservice.inventory.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.microservice.inventory.InventoryConstants;
import com.microservice.inventory.response.UserResponseDto;
import com.microservice.inventory.util.RestTemplateUtil;

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
		String urlFindById = InventoryConstants.User.HOST
				.concat(InventoryConstants.User.PORT)
				.concat(InventoryConstants.User.MAIN_PATH)
				.concat(InventoryConstants.User.FIND_BY_ID);
		UserResponseDto dto = restTemplateUtil.postForObject(urlFindById, username, UserResponseDto.class);
		return dto;
	}
    
}
