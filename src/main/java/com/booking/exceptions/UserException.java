package com.booking.exceptions;

public class UserException extends RuntimeException{

	private String message;

	public UserException(String message) {
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}
}
