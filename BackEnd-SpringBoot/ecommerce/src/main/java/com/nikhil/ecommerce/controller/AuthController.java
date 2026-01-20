package com.nikhil.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nikhil.ecommerce.dto.LoginRequestDto;
import com.nikhil.ecommerce.dto.LoginResponseDto;
import com.nikhil.ecommerce.service.AuthServiceInterface;

@Controller
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthServiceInterface authServiceInterface;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
		
		String token = authServiceInterface.login(loginRequestDto);
		
		
		return ResponseEntity.ok(new LoginResponseDto(token,"Login SuccessFull"));
		
		
	}
}
