package com.booking.entities;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Bookings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingsId;
	
	@ManyToOne
	@JoinColumn(name = "customer")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "hotel")
	private Hotel hotel;
	
	private Date checkIn;
	
	private Date checkOut;
	
	private int noOfRooms;
	
	private String roomType;
	
	private double totalPrice;
	
	private String bookingStatus;
	
	private Date bookedAtDate;
	
	@OneToOne(mappedBy = "bookings")
	@JsonIgnore
	private Payment payment;
}
