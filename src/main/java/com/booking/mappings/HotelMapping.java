package com.booking.mappings;

import org.springframework.stereotype.Service;

import com.booking.dtos.HotelDto;
import com.booking.entities.Hotel;

@Service
public class HotelMapping {

	public Hotel toHotelEntity(HotelDto hotelDto) {
		Hotel hotel = new Hotel();
		hotel.setHotelId(hotelDto.getHotelId());
		hotel.setHotelName(hotelDto.getHotelName());
		hotel.setHotelAddress(hotelDto.getHotelAddress());
		hotel.setHotelCity(hotelDto.getHotelCity());
		hotel.setHotelPrice(hotelDto.getHotelPrice());
		hotel.setHotelRooms(hotelDto.getHotelRooms());
		return hotel;
	}
	
	public HotelDto toHotelDto(Hotel hotel) {
		HotelDto hotelDto = new HotelDto();
		hotelDto.setHotelId(hotel.getHotelId());
		hotelDto.setHotelName(hotel.getHotelName());
		hotelDto.setHotelAddress(hotel.getHotelAddress());
		hotelDto.setHotelCity(hotel.getHotelCity());
		hotelDto.setHotelPrice(hotel.getHotelPrice());
		hotelDto.setHotelRooms(hotel.getHotelRooms());
		return hotelDto;
	}
}
