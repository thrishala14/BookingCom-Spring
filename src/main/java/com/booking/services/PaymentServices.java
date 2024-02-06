package com.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dtos.PaymentDto;
import com.booking.mappings.PaymentMapping;
import com.booking.repositories.PaymentRepository;

@Service
public class PaymentServices {
	
	@Autowired
	private PaymentRepository repo;
	
	@Autowired
	private PaymentMapping map;
	
	public PaymentDto addPayment(PaymentDto dto) {
		return map.toDto(repo.save(map.toEntitity(dto)));
	}
}
