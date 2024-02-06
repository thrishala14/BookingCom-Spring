package com.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.booking.entities.Customer;

import jakarta.transaction.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value = "select * from customer where customer_email = ?1 ", nativeQuery = true)
	Customer findByEmail(String email);
	
	@Modifying
	@Transactional
	@Query(value = "update customer set customer_photo = ?1 where customer_id = ?2 ", nativeQuery = true)
	void updateProfilePic(byte[] bytes, int custId);
}
