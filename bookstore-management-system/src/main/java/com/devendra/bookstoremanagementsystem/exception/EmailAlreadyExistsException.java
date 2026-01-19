package com.devendra.bookstoremanagementsystem.exception;

public class EmailAlreadyExistsException extends RuntimeException {
	
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
