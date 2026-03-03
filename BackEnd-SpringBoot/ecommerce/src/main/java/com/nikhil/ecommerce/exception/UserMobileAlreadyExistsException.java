package com.nikhil.ecommerce.exception;

public class UserMobileAlreadyExistsException extends RuntimeException{
	
    private static final long serialVersionUID = 1L;

    public UserMobileAlreadyExistsException(String message) {
        super(message);
    }

}
