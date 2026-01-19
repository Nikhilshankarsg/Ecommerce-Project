package com.nikhil.ecommerce.service;

import com.nikhil.ecommerce.dto.LoginRequestDto;

public interface AuthServiceInterface {
	
	String login(LoginRequestDto loginRequestDto);

}
