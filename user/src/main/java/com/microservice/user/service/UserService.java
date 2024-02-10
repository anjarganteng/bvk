package com.microservice.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.microservice.user.entity.User;
import com.microservice.user.repository.UserRepository;
import com.microservice.user.request.UserRequestDto;
import com.microservice.user.response.UserResponseDto;
import com.microservice.user.util.JwtUtil;

@Service
public class UserService implements UserDetailsService {	
	private UserRepository userRepository;
	PasswordEncoder passwordEncoder;
	
	public UserService(JwtUtil jwtUtil, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOpt = userRepository.findById(username);
		User user = userOpt.get();
        List<String> roles = new ArrayList<String>();
        roles.add("USER");
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .roles(roles.toArray(new String[0]))
                        .build();
        return userDetails;
    }
    
    public void save(UserRequestDto userDto) {
    	User user = new User(userDto);
    	user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    	userRepository.save(user);
    }

	public UserResponseDto findById(String username) {
		try {
			User user = userRepository.findById(username).get();
			return new UserResponseDto(user);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<UserResponseDto> findAll() {
		List<User> users = userRepository.findAll();
		List<UserResponseDto> userDtos = new ArrayList<UserResponseDto>();
		for(User user : users) {
			userDtos.add(new UserResponseDto(user));
		}
		return userDtos;
	}
	
}
