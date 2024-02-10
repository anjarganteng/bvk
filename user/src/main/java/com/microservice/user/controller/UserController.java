package com.microservice.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.user.UserConstants;
import com.microservice.user.request.UserRequestDto;
import com.microservice.user.response.MessageResponseDto;
import com.microservice.user.response.UserResponseDto;
import com.microservice.user.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(UserConstants.User.MAIN_PATH)
public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@SecurityRequirement(name = "Authorization")
	@PostMapping(value = UserConstants.User.ADD, produces = MediaType.APPLICATION_JSON_VALUE)
	private void findById(@RequestBody UserRequestDto userDto){
		userService.save(userDto);
	}

	@SecurityRequirement(name = "Authorization")
	@PostMapping(value = UserConstants.User.FIND_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	private UserResponseDto findById(@RequestBody String username){
		return userService.findById(username);
	}

	@SecurityRequirement(name = "Authorization")
	@PostMapping(value = UserConstants.User.FIND_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
	private List<UserResponseDto> findAll(){
		return userService.findAll();
	}

}
