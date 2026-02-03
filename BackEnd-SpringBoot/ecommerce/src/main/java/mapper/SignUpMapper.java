package mapper;

import com.nikhil.ecommerce.dto.SignUpRequestDto;
import com.nikhil.ecommerce.entity.UserEntity;

public class SignUpMapper {
	
	public static UserEntity userEntity(SignUpRequestDto signUpRequestDto) {
		
		if(signUpRequestDto == null) {
			return null;
		}
		
		UserEntity userEntity = new UserEntity();
		userEntity.setName(signUpRequestDto.getName());
		userEntity.setEmail(signUpRequestDto.getEmail());
		userEntity.setMobileNumber(signUpRequestDto.getMobileNumber());
		userEntity.setPassword(signUpRequestDto.getMobileNumber());
		return userEntity;
		
		
	}

}
