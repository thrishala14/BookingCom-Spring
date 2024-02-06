package com.booking.exceptions;


public class SavedListException extends RuntimeException{

	private String message;
	
	public SavedListException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	public SavedListException(String message, Throwable cause) {
		super(message, cause);
	}
}
