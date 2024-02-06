package com.booking.dtos;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class CustomerDto {

	private int customerId;
	
	private String firstName;
	
	private String lastName;
	
	private byte[] customerPhoto;
	
	private String role;
	
	private String customerEmail;
	
	private String customerPhone;
	
	private Date customerDob;
	
	private String customerPassword;
	
	private List<SavedListDto> savedList;
	

	private List<BookingsDto> bookings;
}
