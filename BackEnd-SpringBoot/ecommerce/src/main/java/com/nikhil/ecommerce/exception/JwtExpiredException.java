package com.nikhil.ecommerce.exception;

// ✅ Custom runtime exception for invalid JWT
public class JwtExpiredException extends RuntimeException {

    public JwtExpiredException(String message) {
        super(message);
    }
}