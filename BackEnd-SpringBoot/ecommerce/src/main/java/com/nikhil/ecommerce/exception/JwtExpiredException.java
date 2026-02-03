package com.nikhil.ecommerce.exception;

// ✅ Custom runtime exception for invalid JWT
public class JwtExpiredException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JwtExpiredException(String message) {
        super(message);
    }
}