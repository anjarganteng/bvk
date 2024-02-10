package com.microservice.user.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.user.UserConstants;
import com.microservice.user.request.LoginRequestDto;
import com.microservice.user.response.LoginResponseDto;
import com.microservice.user.response.MessageResponseDto;
import com.microservice.user.response.UserResponseDto;
import com.microservice.user.service.UserService;
import com.microservice.user.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(UserConstants.Auth.MAIN_PATH)
public class AuthController {
	@Autowired
	HttpServletRequest request;
	
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private UserService userService;
    
    public AuthController(UserService userService, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userService = userService;
		this.jwtUtil = jwtUtil;
		this.authenticationManager = authenticationManager;
    }

    @ResponseBody
    @RequestMapping(value = UserConstants.Auth.LOGIN, method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginReq)  {
        try {        	
        	Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword()));
            String username = authentication.getName();
            UserResponseDto user = userService.findById(username);
            String token = jwtUtil.createToken(user);
            LoginResponseDto loginRes = new LoginResponseDto(username,token);
            return ResponseEntity.ok(loginRes);
        }catch (BadCredentialsException e){
        	e.printStackTrace();
            MessageResponseDto messageResponse = new MessageResponseDto(HttpStatus.BAD_REQUEST, "Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageResponse);
        }catch (Exception e){
        	e.printStackTrace();
        	MessageResponseDto messageResponse = new MessageResponseDto(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageResponse);
        }
    }

}
