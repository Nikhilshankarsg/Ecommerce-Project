package com.nikhil.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.ecommerce.dto.LoginRequestDto;
import com.nikhil.ecommerce.dto.LoginResponseDto;
import com.nikhil.ecommerce.dto.SignUpRequestDto;
import com.nikhil.ecommerce.dto.SignUpResponseDto;
import com.nikhil.ecommerce.service.AuthServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthServiceInterface authServiceInterface;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequestDto){
		
		String token = authServiceInterface.login(loginRequestDto);
		
		
		return ResponseEntity.ok(new LoginResponseDto(token,"Login SuccessFull"));
		
	}
	
	@PostMapping("/signUp")
	public ResponseEntity<SignUpResponseDto> signUp(@Valid @RequestBody SignUpRequestDto signUpRequestDto){
		
		SignUpResponseDto signUpResponseDto = authServiceInterface.signup(signUpRequestDto);

	        return ResponseEntity.ok(signUpResponseDto);
	}
}
