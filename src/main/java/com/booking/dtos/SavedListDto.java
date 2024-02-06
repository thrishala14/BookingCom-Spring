package com.booking.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class SavedListDto {
	
	private int savedListId;
	
	private CustomerDto customer;
	
	private HotelDto hotel;
}
