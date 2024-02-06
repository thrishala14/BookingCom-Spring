package com.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.booking.entities.Hotel;

import jakarta.transaction.Transactional;

import java.util.List;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{

	public List<Hotel> findByHotelCityContainsAllIgnoreCase(String hotelName);
	
	@Modifying
	@Transactional
	@Query(value = "update hotel set hotel_rooms = hotel_rooms - ?2 where hotel_id = ?1", nativeQuery = true)
	public void updateHotelRooms(int hotelId, int booked);
	
	@Query(value = "select hotel_rooms from hotel where hotel_id = ?1", nativeQuery = true)
	public int getHotelRooms(int id);

	@Modifying
	@Transactional
	@Query(value = "update hotel set hotel_rooms = hotel_rooms + ?2 where hotel_id = ?1", nativeQuery = true)
	public void updateHotelRoomsAdd(int hotelId, int rooms);
}
