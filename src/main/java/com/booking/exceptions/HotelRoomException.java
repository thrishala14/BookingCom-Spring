package com.booking.exceptions;

@SuppressWarnings("serial")
public class HotelRoomException extends RuntimeException{

	private String message;
	
	public HotelRoomException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
