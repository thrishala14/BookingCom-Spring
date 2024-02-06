package com.booking.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dtos.SavedListDto;
import com.booking.exceptions.SavedListException;
import com.booking.services.SavedListService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/saved-list")
public class SavedListController {

	@Autowired
	private SavedListService savedListService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addToSaveList(@RequestBody SavedListDto savedListDto) {
		Optional<SavedListDto> savedDto = Optional.ofNullable(savedListService.addToSaveList(savedListDto));
		if(savedDto.isPresent()) {
			return ResponseEntity.ok(savedDto);
		}
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/get/{id}")
	public List<SavedListDto> retrieveSavedList(@PathVariable int id){  
		return savedListService.retrieveSavedList(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteHotelFromSavedList(@PathVariable int id) {
		savedListService.deleteHotelFromSavedList(id);
	}
}
