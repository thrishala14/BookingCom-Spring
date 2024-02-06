package com.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.booking.services.HotelServices;

@SpringBootTest
class BookingComApplicationTests {

	@Autowired
	HotelServices hotelServices;
	


}
