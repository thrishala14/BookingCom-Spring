package com.booking.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class PaymentDto {
	
	private int paymentId;
	
	private double amount;
	
	private Date paymentDate;
	
	private String paymentMode;
	
	private BookingsDto bookingsDto;
}
