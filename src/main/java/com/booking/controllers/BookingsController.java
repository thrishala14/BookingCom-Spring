package com.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dtos.BookingsDto;
import com.booking.dtos.HotelDto;
import com.booking.services.BookingsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bookings")
public class BookingsController {
	
	@Autowired
	private BookingsService bookingsService;
	
	@PostMapping("/reserve")
	public ResponseEntity<BookingsDto> addToBookings(@RequestBody BookingsDto bookingsDto) {
		return new ResponseEntity<>(bookingsService.addToBooking(bookingsDto), HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<BookingsDto>> retrieveBookings(@PathVariable int id){
		return new ResponseEntity<List<BookingsDto>>( bookingsService.retriveBookings(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteHotelFromBooking(@PathVariable int id) {
		bookingsService.deleteHotelFromBookings(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBooking(@PathVariable int id) {
		bookingsService.updateBooking(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/check-rooms")
	public ResponseEntity<HotelDto> updateRooms(@RequestParam("id") int id, @RequestParam("rooms") int rooms){
		return new ResponseEntity<HotelDto>( bookingsService.updateHotelRooms(id, rooms), HttpStatus.OK);
	}
	
	@PutMapping("/check-rooms-add")
	public ResponseEntity<HotelDto> updateRoomsAdd(@RequestParam("id") int id, @RequestParam("rooms") int rooms){
		return new ResponseEntity<HotelDto>( bookingsService.updateHotelRoomsAdd(id, rooms), HttpStatus.OK);
	}
}
