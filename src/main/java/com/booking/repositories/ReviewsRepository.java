package com.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.entities.Reviews;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {

}
