package com.booking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.booking.dtos.HotelDto;
import com.booking.dtos.HotelImageDto;
import com.booking.entities.Hotel;
import com.booking.entities.HotelImages;
import com.booking.mappings.HotelImageMapping;
import com.booking.mappings.HotelMapping;
import com.booking.repositories.HotelImagesRepository;
import com.booking.repositories.HotelRepository;

@Service
public class AdminService {

	@Autowired
	private HotelMapping hotelMapping;
	
	@Autowired
	private HotelImageMapping imageMapping;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private HotelImagesRepository imageRepository;
	
	/**
	 * takes HotelDto as parameter and saves the Hotel and the corresponding hotel images into the Hotel and Hotel_Images
	 * table, returns a HotelDto object
	 * @param hotelDto
	 * @return 
	 */
	public HotelDto saveHotel(HotelDto hotelDto) {
		List<HotelImages> hotelImages = new ArrayList<>();
		Hotel hotel = new Hotel();
		hotel = hotelMapping.toHotelEntity(hotelDto);
		Hotel hotelSaved = hotelRepository.save(hotel);
		for(HotelImageDto i: hotelDto.getImages()) {
			HotelImages img = imageMapping.toImageEntity(i);
			img.setHotel(hotel);
			hotelImages.add(img);
		}
		List<HotelImages> imgs = imageRepository.saveAll(hotelImages);
		HotelDto hotelReturn = new HotelDto();
		hotelReturn = hotelMapping.toHotelDto(hotelSaved);
		List<HotelImageDto> dtoReturn = new ArrayList<>();
		for(HotelImages i: imgs) {
			dtoReturn.add(imageMapping.toImageDto(i));
		}
		hotelReturn.setImages(dtoReturn);
		return hotelReturn;
	}
	
	public String deleteHotel(int id) {
		hotelRepository.deleteById(id);
		return "Deleted Successfully";
	}
	
	public String deleteHotelImage(int id) {
		imageRepository.deleteById(id);
		return "Deleted Image Successfully";
	}
	
	public HotelImageDto addHotelImage(HotelImageDto dto ) {
		Hotel hotel = hotelMapping.toHotelEntity(dto.getHotelDto());
		HotelImages img = imageMapping.toImageEntity(dto);
		img.setHotel(hotel);
		HotelImages imgSaved = imageRepository.save(img);
		return imageMapping.toImageDto(imgSaved);
	}
	
	public HotelDto modifyHotel(HotelDto hotelDto) {
		List<HotelImages> hotelImages = new ArrayList<>();
		Hotel hotel = new Hotel();
		hotel = hotelMapping.toHotelEntity(hotelDto);
		Hotel hotelSaved = hotelRepository.save(hotel);
		for(HotelImageDto i: hotelDto.getImages()) {
			HotelImages img = imageMapping.toImageEntity(i);
			img.setHotel(hotel);
			hotelImages.add(img);
		}
		List<HotelImages> imgs = imageRepository.saveAll(hotelImages);
		HotelDto hotelReturn = new HotelDto();
		hotelReturn = hotelMapping.toHotelDto(hotelSaved);
		List<HotelImageDto> dtoReturn = new ArrayList<>();
		for(HotelImages i: imgs) {
			dtoReturn.add(imageMapping.toImageDto(i));
		}
		hotelReturn.setImages(dtoReturn);
		return hotelReturn;
	}
}
