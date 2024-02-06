package com.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dtos.HotelDto;
import com.booking.dtos.HotelImageDto;
import com.booking.services.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/save-hotel")
	public ResponseEntity<HotelDto> saveHotel(@RequestBody HotelDto hotelDto) {
		return new ResponseEntity<>( adminService.saveHotel(hotelDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-hotel/{id}")
	public ResponseEntity<String> deleteHotel(@PathVariable int id){
		return new ResponseEntity<>(adminService.deleteHotel(id),HttpStatus.OK);
	}
	
	@PutMapping("/modify-hotel")
	public ResponseEntity<HotelDto> modifyHotel(@RequestBody HotelDto hotelDto) {
		return new ResponseEntity<>( adminService.modifyHotel(hotelDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-hotel-image/{id}")
	public ResponseEntity<String> deleteHotelImage(@PathVariable int id){
		return new ResponseEntity<>(adminService.deleteHotelImage(id),HttpStatus.OK);
	}
	
	@PostMapping("/add-hotel-image")
	public ResponseEntity<HotelImageDto> saveHotelImage(@RequestBody HotelImageDto dto) {
		return new ResponseEntity<>( adminService.addHotelImage(dto), HttpStatus.OK);
	}
}
