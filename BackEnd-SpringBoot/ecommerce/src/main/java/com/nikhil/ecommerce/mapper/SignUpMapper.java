package com.nikhil.ecommerce.mapper;

import com.nikhil.ecommerce.constants.ApplicationConstants;
import com.nikhil.ecommerce.dto.SignUpRequestDto;
import com.nikhil.ecommerce.dto.SignUpResponseDto;
import com.nikhil.ecommerce.entity.UserEntity;

public class SignUpMapper {
	
	public static UserEntity userEntity(SignUpRequestDto signUpRequestDto) {
		
		if(signUpRequestDto == null) {
			return null;
		}
		
		//Covert Dto --> Entity
		UserEntity userEntity = new UserEntity();
		userEntity.setName(signUpRequestDto.getName());
		userEntity.setEmail(signUpRequestDto.getEmail());
		userEntity.setMobileNumber(signUpRequestDto.getMobileNumber());
		userEntity.setPassword(signUpRequestDto.getPassword());
		userEntity.setRole(signUpRequestDto.getRole());  
		return userEntity;
			
	}
	
	public static SignUpResponseDto signUpResponseDto(UserEntity userEntity) {

	    if (userEntity == null) {
	        return null;
	    }

	    SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
	    signUpResponseDto.setId(userEntity.getId());
	    signUpResponseDto.setName(userEntity.getName());
	    signUpResponseDto.setEmail(userEntity.getEmail());
	    signUpResponseDto.setMobileNumber(userEntity.getMobileNumber());
	    signUpResponseDto.setRole(userEntity.getRole());
	    signUpResponseDto.setMessage(ApplicationConstants.messages);

	    return signUpResponseDto;
	}

}

