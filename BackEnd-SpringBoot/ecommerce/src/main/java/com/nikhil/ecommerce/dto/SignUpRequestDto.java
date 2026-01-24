package com.nikhil.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SignUpRequestDto {
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid mobile number")
	private String mobileNumber;
	
	@NotBlank
	private String password;

}
