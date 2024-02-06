package com.booking.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ReviewsDto {

	private int reviewsId;
	
	private CustomerDto customerDto;
	
	private HotelDto hotelDto;
	
	private String reviewsComment;
	
	private int reviewsRating;
}
