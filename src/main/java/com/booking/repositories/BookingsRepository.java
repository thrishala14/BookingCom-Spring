package com.booking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.booking.entities.Bookings;

import jakarta.transaction.Transactional;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Integer>{

	@Query(value = "select * from bookings where customer = ?1", nativeQuery = true)
	List<Bookings> retrieveById(int id);

	@Modifying
	@Transactional
	@Query(value = "update bookings set booking_status = 'cancelled' where bookings_id = ?1", nativeQuery = true)
	void updateStatus(int id);

}
