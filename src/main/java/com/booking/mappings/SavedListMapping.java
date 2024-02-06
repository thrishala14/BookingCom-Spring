package com.booking.mappings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dtos.SavedListDto;
import com.booking.entities.SavedList;

@Service
public class SavedListMapping {

	@Autowired
	private CustomerMapping customerMapping;
	
	@Autowired
	private HotelMapping hotelMapping;
	
	public SavedList toSavedListEntity(SavedListDto dto) {
		SavedList savedlist = new SavedList();
		savedlist.setSavedListId(dto.getSavedListId());
		savedlist.setCustomer(customerMapping.toCustomerEntity(dto.getCustomer()));
		savedlist.setHotel(hotelMapping.toHotelEntity(dto.getHotel()));
		return savedlist;
	}
	
	public SavedListDto toSavedListDto(SavedList entity) {
		SavedListDto dto = new SavedListDto();
		dto.setSavedListId(entity.getSavedListId());
		dto.setCustomer(customerMapping.toCustomerDto(entity.getCustomer()));
		dto.setHotel(hotelMapping.toHotelDto(entity.getHotel()));
		return dto;
	}
}
