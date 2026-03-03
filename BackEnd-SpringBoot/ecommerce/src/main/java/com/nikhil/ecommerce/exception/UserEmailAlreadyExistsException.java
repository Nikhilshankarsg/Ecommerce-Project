package com.nikhil.ecommerce.exception;

public class UserEmailAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserEmailAlreadyExistsException(String message) {
        super(message);
    }
}
