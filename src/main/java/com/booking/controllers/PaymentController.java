package com.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dtos.PaymentDto;
import com.booking.services.PaymentServices;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "*")
public class PaymentController {

	@Autowired
	private PaymentServices service;
	
	@PostMapping("/new")
	public ResponseEntity<PaymentDto> addPayment(@RequestBody PaymentDto dto){
		return new ResponseEntity<>(service.addPayment(dto), HttpStatus.OK);
	}
}
