package com.booking.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotelId;
	
	private String hotelName;
	
	private String hotelAddress;
	
	private String hotelCity;
	
	private int hotelRooms;
	
	private double hotelPrice;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
	@JsonIgnore
	private List<HotelImages> images;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
	@JsonIgnore
	private List<SavedList> savedList;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
	@JsonIgnore
	private List<Bookings> bookings;
}
