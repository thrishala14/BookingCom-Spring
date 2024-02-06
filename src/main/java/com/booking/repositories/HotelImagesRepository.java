package com.booking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.entities.Hotel;
import com.booking.entities.HotelImages;

@Repository
public interface HotelImagesRepository extends JpaRepository<HotelImages, Integer>{

	List<HotelImages> findByHotel(Hotel hotel);

}
