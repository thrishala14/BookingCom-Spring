package com.booking.mappings;

import org.springframework.stereotype.Service;

import com.booking.dtos.HotelImageDto;
import com.booking.entities.HotelImages;

@Service
public class HotelImageMapping {

	
	public HotelImages toImageEntity(HotelImageDto dto) {
		HotelImages hotelImg = new HotelImages();
		hotelImg.setHotelImageId(dto.getHotelImageId());
		hotelImg.setHotelImage(dto.getHotelImage());
		return hotelImg;
	}
	
	public HotelImageDto toImageDto(HotelImages image) {
		HotelImageDto dto = new HotelImageDto();
		dto.setHotelImageId(image.getHotelImageId());
		dto.setHotelImage(image.getHotelImage());
		return dto;
	}
}
