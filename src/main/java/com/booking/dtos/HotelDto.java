package com.booking.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class HotelDto {

	private int hotelId;
	
	private String hotelName;
	
	private String hotelAddress;
	
	private String hotelCity;
	
	private int hotelRooms;
	
	private double hotelPrice;
	
	private List<HotelImageDto> images;
	
	private List<SavedListDto> savedList;
	
	private List<BookingsDto> bookings;
}
