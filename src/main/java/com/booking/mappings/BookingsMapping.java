package com.booking.mappings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dtos.BookingsDto;
import com.booking.entities.Bookings;

@Service
public class BookingsMapping {
	
	@Autowired
	private CustomerMapping customerMapping;
	
	@Autowired
	private HotelMapping hotelMapping;
	
	public Bookings toBookingsEntity(BookingsDto bookingsDto) {
		Bookings bookings =Bookings.of(bookingsDto.getBookingsId(), 
				customerMapping.toCustomerEntity(bookingsDto.getCustomer()), 
				hotelMapping.toHotelEntity(bookingsDto.getHotel()), 
				bookingsDto.getCheckIn(), 
				bookingsDto.getCheckOut(), 
				bookingsDto.getNoOfRooms(), 
				bookingsDto.getRoomType(), 
				bookingsDto.getTotalPrice(), 
				bookingsDto.getBookingStatus(), 
				bookingsDto.getBookedAtDate(),
				null);
		return bookings;
	}
	
	public BookingsDto toBookingsDto(Bookings bookings) {
		BookingsDto bookingsDto =BookingsDto.of(bookings.getBookingsId(), 
				customerMapping.toCustomerDto(bookings.getCustomer()), 
				hotelMapping.toHotelDto(bookings.getHotel()),
				bookings.getCheckIn(), 
				bookings.getCheckOut(), 
				bookings.getNoOfRooms(), 
				bookings.getRoomType(), 
				bookings.getTotalPrice(), 
				bookings.getBookingStatus(), 
				bookings.getBookedAtDate(),
				null);
		return bookingsDto;
	}

	
	public Bookings toEntity(BookingsDto bookingsDto) {
		Bookings bookings = new Bookings();
		bookings.setBookedAtDate(bookingsDto.getBookedAtDate());
		bookings.setBookingsId(bookingsDto.getBookingsId());
		bookings.setBookingStatus(bookingsDto.getBookingStatus());
		bookings.setCheckIn(bookingsDto.getCheckIn());
		bookings.setCheckOut(bookingsDto.getCheckOut());
		bookings.setNoOfRooms(bookingsDto.getNoOfRooms());
		bookings.setRoomType(bookingsDto.getRoomType());
		bookings.setTotalPrice(bookingsDto.getTotalPrice());
		return bookings;
	}
	
	public BookingsDto toDto(Bookings bookings) {
		BookingsDto dto = new BookingsDto();
		dto.setBookedAtDate(bookings.getBookedAtDate());
		dto.setBookingsId(bookings.getBookingsId());
		dto.setBookingStatus(bookings.getBookingStatus());
		dto.setCheckIn(bookings.getCheckIn());
		dto.setCheckOut(bookings.getCheckOut());
		dto.setNoOfRooms(bookings.getNoOfRooms());
		dto.setRoomType(bookings.getRoomType());
		dto.setTotalPrice(bookings.getTotalPrice());
		return dto;
	}
}
