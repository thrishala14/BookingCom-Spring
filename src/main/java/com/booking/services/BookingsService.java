package com.booking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dtos.BookingsDto;
import com.booking.dtos.HotelDto;
import com.booking.entities.Bookings;
import com.booking.entities.Customer;
import com.booking.entities.Hotel;
import com.booking.exceptions.HotelRoomException;
import com.booking.mappings.BookingsMapping;
import com.booking.mappings.CustomerMapping;
import com.booking.mappings.HotelMapping;
import com.booking.repositories.BookingsRepository;
import com.booking.repositories.CustomerRepository;
import com.booking.repositories.HotelRepository;


@RestController
public class BookingsService {

	@Autowired
	private BookingsRepository bookingsRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private CustomerMapping customerMapping;
	
	@Autowired
	private HotelMapping hotelMapping;
	
	@Autowired
	private BookingsMapping bookingsMapping;
	
	/**
	 * addToBooking() -> This method is for saving a booking object to the repository.
	 * @param BookingsDto bookingsDto
	 */
	public BookingsDto addToBooking(BookingsDto bookingsDto) {
		Bookings bookings = bookingsMapping.toEntity(bookingsDto);
		Hotel hotel = hotelMapping.toHotelEntity(bookingsDto.getHotel());
		Customer customer = customerMapping.toCustomerEntity(bookingsDto.getCustomer());
		bookings.setCustomer(customer);
		bookings.setHotel(hotel);
		Bookings bookingsReturn = bookingsRepository.save(bookings);
		return bookingsMapping.toDto(bookingsReturn);
	}
	
	/**
	 * retriveBookings() -> This method returns list of bookings of the customer with customer id 'id'.
	 * @param int id
	 * @return List<BookingsDto> bookingDtos
	 */
	public List<BookingsDto> retriveBookings(int id){
		List<BookingsDto> bookingDtos = new ArrayList<>();
		for(Bookings b: bookingsRepository.retrieveById(id)) {
			
			bookingDtos.add(bookingsMapping.toBookingsDto(b));
		}
		return bookingDtos;
	}
	
	/**
	 * deleteHotelFromBookings() -> This method deletes the booking based on the bookings id.
	 * @param int id
	 */
	public void deleteHotelFromBookings(int id) {
		bookingsRepository.deleteById(id);
	}
	
	/**
	 * updateBooking()-> This method updates the booking status to "cancelled"
	 * @param int id
	 */
	public void updateBooking(int id) {
		 bookingsRepository.updateStatus(id);
	}
	
	/**
	 * updateHotelRooms()-> If available rooms in hotel is greater than rooms booked 
	 * return hotelDto after deducting rooms 
	 * else throw exception "Rooms not available"
	 * @param int hotelId
	 * @param int rooms
	 * @return HotelDto
	 */
	public HotelDto updateHotelRooms(int hotelId, int rooms) {
		if(hotelRepository.getHotelRooms(hotelId) > rooms) {
			hotelRepository.updateHotelRooms(hotelId, rooms);
			Hotel hotel = hotelRepository.findById(hotelId).orElse(null);
			return hotelMapping.toHotelDto(hotel);
		}
		else throw new HotelRoomException("Rooms not available");
	}
	
	/**
	 * updateHotelRoomsAdd()-> If hotel booking cancelled update the available hotel rooms 
	 * by the number of rooms booked.
	 * @param int hotelId
	 * @param int rooms
	 * @return
	 */
	public HotelDto updateHotelRoomsAdd(int hotelId, int rooms) {
		hotelRepository.updateHotelRoomsAdd(hotelId, rooms);
		Hotel hotel = hotelRepository.findById(hotelId).orElse(null);
		return hotelMapping.toHotelDto(hotel);
	}
}
