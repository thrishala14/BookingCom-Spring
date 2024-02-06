package com.booking.mappings;

import org.springframework.stereotype.Service;

import com.booking.dtos.CustomerDto;
import com.booking.entities.Customer;

@Service
public class CustomerMapping {

	
	public Customer toCustomerEntity(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setCustomerId(customerDto.getCustomerId());
		customer.setCustomerDob(customerDto.getCustomerDob());
		customer.setCustomerEmail(customerDto.getCustomerEmail());
		customer.setRole(customerDto.getRole());
		customer.setCustomerPassword(customerDto.getCustomerPassword());
		customer.setCustomerPhone(customerDto.getCustomerPhone());
		customer.setCustomerPhoto(customerDto.getCustomerPhoto());
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		
		return customer;
	}
	
	public CustomerDto toCustomerDto(Customer customer) {
		
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomerId(customer.getCustomerId());
		customerDto.setCustomerDob(customer.getCustomerDob());
		customerDto.setCustomerEmail(customer.getCustomerEmail());
		customerDto.setCustomerPassword(customer.getCustomerPassword());
		customerDto.setCustomerPhone(customer.getCustomerPhone());
		customerDto.setRole(customer.getRole());
		customerDto.setCustomerPhoto(customer.getCustomerPhoto());
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		
		return customerDto;
	}
	
}
