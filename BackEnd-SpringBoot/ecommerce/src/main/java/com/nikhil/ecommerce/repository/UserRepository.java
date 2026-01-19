package com.nikhil.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.ecommerce.entity.UserEntity;

public interface UserRepository extends JpaRepository<Long, UserEntity>{
	
	<optional> UserEntity findByUserName(String username);

}
