package com.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
