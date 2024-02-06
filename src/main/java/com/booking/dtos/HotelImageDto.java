package com.booking.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class HotelImageDto {
	
	private int hotelImageId;
	
	private HotelDto hotelDto;
	
	private String hotelImage;
}
