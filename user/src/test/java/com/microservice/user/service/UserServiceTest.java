package com.microservice.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import com.microservice.user.request.UserRequestDto;
import com.microservice.user.response.UserResponseDto;

@SpringBootTest
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void testLoadUserByUsername() {
		//FIND USERNAME "rey"
		UserDetails userDetails = userService.loadUserByUsername("rey");
		//USERNAME REY IS NOT NULL
		assertThat(userDetails).isNotNull();
	}
	
	@Test
	public void testSave() {
		//INIT USER
		UserRequestDto saveUserDto = new UserRequestDto();
		saveUserDto.setUsername("user1");
		saveUserDto.setPassword("password");
		saveUserDto.setFirstname("Ida");
		saveUserDto.setLastname("Atika");
		//SAVE USER
		userService.save(saveUserDto);
		//FIND SAVED USER
		UserResponseDto findUserDto = userService.findById(saveUserDto.getUsername());
		//CHECK SAVED USER IS NOT NULL
		assertThat(findUserDto)
				.isNotNull();
		//CHECK SAVED USER MATCH
        assertThat(findUserDto.getUsername())
        		.isEqualTo(saveUserDto.getUsername());
	}
	
	@Test
	public void testFindById() {
		//FIND USERNAME "rey"
		UserResponseDto userDto = userService.findById("rey");
		//USERNAME REY IS NOT NULL
		assertThat(userDto).isNotNull();
	}
	
	@Test
	public void testFindAll() {
		//FIND ALL USER
		List<UserResponseDto> userDtos = userService.findAll();
		//USER IS NOT NULL 
		//USER HAS 3 SAMPLE DATA "rey", "axel", "anjar"
		assertThat(userDtos)
				.isNotNull()
				.hasSize(3)
                .extracting(UserResponseDto::getUsername)
				.contains("rey", "axel", "anjar");	
	}
	
}
