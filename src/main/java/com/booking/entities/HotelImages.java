package com.booking.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class HotelImages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotelImageId;
	
	@ManyToOne
	@JoinColumn(name = "hotelId", nullable = true)
	private Hotel hotel;
	
	private String hotelImage;
}
