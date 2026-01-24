package com.nikhil.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="email", nullable = false, unique = true)
	private String email;
	
	@Column(name="mobilenumber", nullable = false, unique = true)
	private String mobileNumber;

	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="role")
	private String role;

}
