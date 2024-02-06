package com.booking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.booking.entities.SavedList;

@Repository
public interface SavedListRepository extends JpaRepository<SavedList, Integer>{
	
	@Query(value = "select * from saved_list where customer = ?1", nativeQuery = true)
	public List<SavedList> retrieveById(int id);

}
