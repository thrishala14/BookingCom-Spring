package com.booking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dtos.SavedListDto;
import com.booking.entities.SavedList;
import com.booking.exceptions.SavedListException;
import com.booking.mappings.SavedListMapping;
import com.booking.repositories.SavedListRepository;

@Service
public class SavedListService {
	
	@Autowired
	private SavedListRepository savedListRepository;

	@Autowired
	private SavedListMapping listMapping;
	
	/**
	 * addToSaveList() -> This method is for adding a saved list object.
	 * It checks if the hotel is already present in the user's saved list.
	 * If present throws an exception else saves into the repository.
	 * @param SavedListDto savedListDto
	 * @return SavedListDto savedListDtoReturned
	 */
	public SavedListDto addToSaveList(SavedListDto savedListDto) {
		SavedList savedlist = listMapping.toSavedListEntity(savedListDto);
		List<SavedList> list = savedListRepository.retrieveById(savedlist.getCustomer().getCustomerId());
		if(list.stream().anyMatch(t -> t.getHotel().getHotelId()==savedlist.getHotel().getHotelId())) {
			throw new SavedListException("Hotel already added to saved list");
		}
		else {
			SavedListDto savedListDtoReturned = listMapping.toSavedListDto( savedListRepository.save(savedlist));
			return savedListDtoReturned;
		}
	}
	
	
	/**
	 * retrieveSavedList() -> This method is for retrieving the saved list corresponding to the customerId
	 * @param int id
	 * @return List<SavedListDto> savedListDtos
	 */
	public List<SavedListDto> retrieveSavedList(int id){
		List<SavedList> savedList = savedListRepository.retrieveById(id);
		List<SavedListDto> savedListDtos = new ArrayList<>();
		for(SavedList i: savedList) {
			savedListDtos.add(listMapping.toSavedListDto(i));
		}
		return savedListDtos;
	}
	
	
	/**
	 * deleteHotelFromSavedList() -> This method deletes the saved list by the saved list Id.
	 * @param int id
	 */
	public void deleteHotelFromSavedList(int id) {
		savedListRepository.deleteById(id);
	}
	
}
