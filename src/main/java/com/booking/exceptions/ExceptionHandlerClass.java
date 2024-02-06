package com.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandlerClass {
	
	
	/**
	 * Handles customer login and register exceptions
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(UserException.class)
	public ResponseEntity<Object> handleUserException(UserException ex){
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Handles custom exception if hotel already present in the user saved list
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(SavedListException.class)
	public ResponseEntity<Object> handleSavedListException(SavedListException ex){
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Handles custom exception if rooms booked is greater than the rooms available in the hotel.
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(HotelRoomException.class)
	public ResponseEntity<Object> handleHotelRoomException(HotelRoomException ex){
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

