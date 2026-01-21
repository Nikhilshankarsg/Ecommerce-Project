package com.nikhil.ecommerce.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhil.ecommerce.dto.LoginRequestDto;
import com.nikhil.ecommerce.entity.UserEntity;
import com.nikhil.ecommerce.exception.InvalidCredentialsException;
import com.nikhil.ecommerce.exception.UserNotFoundException;
import com.nikhil.ecommerce.repository.UserRepository;
import com.nikhil.ecommerce.service.AuthServiceInterface;
import com.nikhil.ecommerce.utils.JwtUtils;

@Service
public class AuthServiceImpl implements AuthServiceInterface{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtUtils jwtUtils;

	@Override
	public String login(LoginRequestDto loginRequestDto) {
		
		UserEntity userEntity = userRepository.findByEmail(loginRequestDto.getEmail())
		        .orElseThrow(() -> new UserNotFoundException("Email not found"));

		
		if(!loginRequestDto.getPassword().equals(userEntity.getPassword())) {
			throw new InvalidCredentialsException("Password is Incorrect for the Email");
		}
		
		
		return jwtUtils.generateToken(userEntity.getEmail());
	}

}
