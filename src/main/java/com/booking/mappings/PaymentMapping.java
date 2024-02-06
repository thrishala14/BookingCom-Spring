package com.booking.mappings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dtos.PaymentDto;
import com.booking.entities.Payment;

@Service
public class PaymentMapping {

	@Autowired
	private BookingsMapping map;
	
	public PaymentDto toDto(Payment payment) {
		PaymentDto dto = new PaymentDto();
		dto.setPaymentId(payment.getPaymentId());
		dto.setAmount(payment.getAmount());
		dto.setBookingsDto(map.toBookingsDto(payment.getBookings()));
		dto.setPaymentDate(payment.getPaymentDate());
		dto.setPaymentMode(payment.getPaymentMode());
		return dto;
	}
	
	public Payment toEntitity(PaymentDto dto) {
		Payment payment = new Payment();
		payment.setPaymentId(dto.getPaymentId());
		payment.setAmount(dto.getAmount());
		payment.setBookings(map.toBookingsEntity(dto.getBookingsDto()));
		payment.setPaymentDate(dto.getPaymentDate());
		payment.setPaymentMode(dto.getPaymentMode());
		return payment;
	}
}
