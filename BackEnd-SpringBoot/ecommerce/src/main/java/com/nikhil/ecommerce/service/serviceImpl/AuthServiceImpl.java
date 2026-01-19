package com.nikhil.ecommerce.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.nikhil.ecommerce.dto.LoginRequestDto;
import com.nikhil.ecommerce.entity.UserEntity;
import com.nikhil.ecommerce.repository.UserRepository;
import com.nikhil.ecommerce.service.AuthServiceInterface;
import com.nikhil.ecommerce.utils.JwtUtils;

public class AuthServiceImpl implements AuthServiceInterface{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtUtils jwtUtils;

	@Override
	public String login(LoginRequestDto loginRequestDto) {
		
		UserEntity userEntity = userRepository.findByUserName(loginRequestDto.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		if(loginRequestDto.getPassword().equals(userEntity.getPassword())) {
			throw new RunTimeException("Invalid Credentials");
		}
		
		
		return jwtUtils.generateToken(userEntity.getUsername());
	}

}
