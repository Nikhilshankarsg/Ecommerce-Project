package com.nikhil.ecommerce.service;

import com.nikhil.ecommerce.dto.LoginRequestDto;
import com.nikhil.ecommerce.dto.SignUpRequestDto;
import com.nikhil.ecommerce.dto.SignUpResponseDto;

public interface AuthServiceInterface {
	
	String login(LoginRequestDto loginRequestDto);

	SignUpResponseDto signup(SignUpRequestDto signUpRequestDto);

}
