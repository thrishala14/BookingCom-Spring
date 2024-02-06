package com.booking.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class BookingsDto {
	
	private int bookingsId;
	
	private CustomerDto customer;
	
	private HotelDto hotel;
	
	private Date checkIn;
	
	private Date checkOut;
	
	private int noOfRooms;
	
	private String roomType;
	
	private double totalPrice;
	
	private String bookingStatus;
	
	private Date bookedAtDate;
	
	private PaymentDto paymentDto;
}
