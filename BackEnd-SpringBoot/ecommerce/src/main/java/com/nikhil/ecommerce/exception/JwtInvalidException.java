package com.nikhil.ecommerce.exception;

public class JwtInvalidException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JwtInvalidException(String message) {
        super(message);
    }

}
