package com.nikhil.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.ecommerce.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	/*
	 * For Login
	 */
	Optional<UserEntity> findByEmail(String email);
	
	/*
	 *For SignUp
	 */
	boolean existsByEmail(String email);
	
	boolean existsByMobileNumber(String mobileNumber);

}
