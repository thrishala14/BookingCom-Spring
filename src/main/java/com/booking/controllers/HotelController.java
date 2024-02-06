package com.booking.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.booking.dtos.CustomerDto;
import com.booking.dtos.HotelDto;
import com.booking.dtos.HotelImageDto;
import com.booking.entities.Customer;
import com.booking.entities.Hotel;
import com.booking.exceptions.UserException;
import com.booking.services.HotelServices;

import jakarta.persistence.EntityNotFoundException;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "*")
public class HotelController {

	Logger logger = LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	private HotelServices hotelServices;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<HotelDto>> getAllHotels(){
		return ResponseEntity.ok(hotelServices.getAllHotels());
	}
	
	@GetMapping("/getImage/{hotel}")
	public ResponseEntity<List<HotelImageDto>> getHotelImage(@PathVariable Hotel hotel) {
		return ResponseEntity.ok(hotelServices.getHotelImage(hotel));
	}
	
	@GetMapping("/startWith/{str}")
	public ResponseEntity<List<HotelDto>> getHotelsStartingWith(@PathVariable String str){
		return ResponseEntity.ok(hotelServices.getStartingWith(str));
	}
	
//	
//	public ResponseEntity<CustomerDto> registerCustomer(@RequestBody CustomerDto customerDto) {
//		return ResponseEntity.ok(hotelServices.customerRegister(customerDto));
//	}
//	
	
	public ResponseEntity<Optional<CustomerDto>> loginCustomer(@RequestParam String email, @RequestParam String password) {
		Optional<CustomerDto> customerDto = Optional.ofNullable(hotelServices.loginCustomer(email, password));
		if(customerDto.isPresent())
		return new ResponseEntity<>(customerDto, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(customerDto, HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/updateProfile")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(hotelServices.updateCustomerInfo(customer));
	}
	
	@PostMapping("/register")
	public void uploadProfileImage(@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam String customerEmail,
			@RequestParam String customerPhone,
			@RequestParam Date customerDob,
			@RequestParam String role,
			@RequestParam String customerPassword,
			@RequestParam MultipartFile file) throws IOException {
		
		byte [] byteArr=file.getBytes();
		CustomerDto dto = new CustomerDto();
		dto.setCustomerDob(customerDob);
		dto.setCustomerEmail(customerEmail);
		dto.setCustomerPassword(customerPassword);
		dto.setCustomerPhone(customerPhone);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setRole(role);
		dto.setCustomerPhoto(byteArr);
		hotelServices.customerRegister(dto);
	}
	
	@GetMapping("/login")
	public CustomerDto demologinCustomer(@RequestParam String email, @RequestParam String password){
		try{
			return hotelServices.loginCustomer(email, password);
		}catch(UserException e) {
			throw new UserException(e.getMessage());
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PutMapping("/update-profile-pic")
	public void updateProfilePic(@RequestParam MultipartFile file, @RequestParam int custId) throws IOException {
		byte [] byteArr=file.getBytes();
		hotelServices.updateProfilePic(byteArr, custId);
	}
	
}
