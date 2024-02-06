package com.booking.entities;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor( staticName = "of")

public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	private String firstName;
	
	private String lastName;
	
	@Lob
	private byte[] customerPhoto;
	
	private String customerEmail;
	
	private String customerPhone;
	
	private Date customerDob;
	
	private String role;
	
	private String customerPassword;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	@JsonIgnore
	private List<SavedList> savedList;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	@JsonIgnore
	private List<Bookings> bookings;
	
}
