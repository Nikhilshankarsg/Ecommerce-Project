package com.nikhil.ecommerce.dto;

import lombok.Data;

@Data
public class SignUpResponseDto {
	
	private Long id;
	private String name;
	private String email;
	private String mobileNumber;
	private String message;

}
