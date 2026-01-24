package com.nikhil.ecommerce.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nikhil.ecommerce.dto.LoginRequestDto;
import com.nikhil.ecommerce.entity.UserEntity;
import com.nikhil.ecommerce.exception.InvalidCredentialsException;
import com.nikhil.ecommerce.exception.UserNotFoundException;
import com.nikhil.ecommerce.repository.UserRepository;
import com.nikhil.ecommerce.service.AuthServiceInterface;
import com.nikhil.ecommerce.utils.JwtUtils;

@Service
public class AuthServiceImpl implements AuthServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;  // Inject PasswordEncoder

    @Override
    public String login(LoginRequestDto loginRequestDto) {

        // 1️⃣ Find user by email
        UserEntity userEntity = userRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(() -> new UserNotFoundException("Email not found"));

        // 2️⃣ Compare passwords using PasswordEncoder
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), userEntity.getPassword())) {
            throw new InvalidCredentialsException("Password is incorrect for the email");
        }

        // 3️⃣ Generate JWT token
        return jwtUtils.generateToken(userEntity.getEmail(), userEntity.getRole());
    }
}
