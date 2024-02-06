package com.booking.services;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.booking.dtos.CustomerDto;
import com.booking.dtos.HotelDto;
import com.booking.dtos.HotelImageDto;
import com.booking.entities.Customer;
import com.booking.entities.Hotel;
import com.booking.entities.HotelImages;
import com.booking.exceptions.UserException;
import com.booking.mappings.CustomerMapping;
import com.booking.mappings.HotelImageMapping;
import com.booking.mappings.HotelMapping;
import com.booking.repositories.CustomerRepository;
import com.booking.repositories.HotelImagesRepository;
import com.booking.repositories.HotelRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class HotelServices {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
    private ModelMapper modelMapper; 
	
	@Autowired
	private HotelImagesRepository hotelImagesRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private HotelImageMapping imageMapping;
	
	@Autowired 
	private HotelMapping hotelMapping;
	
	@Autowired
	private CustomerMapping customerMapping;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/**
	 * getAllHotels() -> list of all the hotels present
	 * @return List<HotelDto> hotelDto
	 */
	public List<HotelDto> getAllHotels() {
		List<Hotel> hotels = new ArrayList<>();
		hotels = hotelRepository.findAll();
		List<HotelDto> hotelDto = new ArrayList<>();
		for(int i =0;i<hotels.size();i++) {
			HotelDto dto = HotelDto.of(hotels.get(i).getHotelId(), hotels.get(i).getHotelName(), hotels.get(i).getHotelAddress(), hotels.get(i).getHotelCity(), hotels.get(i).getHotelRooms(), hotels.get(i).getHotelPrice(), null, null, null);
			hotelDto.add(dto);
		}
		return hotelDto;
	}
	
	/**
	 * getHotelImage() -> This method returns the images associated with the hotel.
	 * @param Hotel hotel
	 * @return List<HotelImageDto> hotelImageDto
	 */
	public List<HotelImageDto> getHotelImage(Hotel hotel){
		List<HotelImages> hotelImages = hotelImagesRepository.findByHotel(hotel);
		List<HotelImageDto> hotelImageDto = new ArrayList<>();
		for(HotelImages hi: hotelImages) {
			hotelImageDto.add(imageMapping.toImageDto(hi));
		}
		return hotelImageDto;
	}
	
	/**
	 * getStartingWith() -> This method returns the list of hotels containing the parameter in the city. 
	 * @param String str
	 * @return List<HotelDto> dto
	 */
	public List<HotelDto> getStartingWith(String str){
		List<Hotel> hotels = new ArrayList<>();
		List<HotelDto> dto = new ArrayList<>();
		hotels = hotelRepository.findByHotelCityContainsAllIgnoreCase(str);
		for(Hotel h: hotels) {
			dto.add(hotelMapping.toHotelDto(h));
		}
		return dto;
	}
	
	/**
	 * customerRegister() -> This method is for customer registration.
	 * If the customer email is present, exception is thrown, else
	 * customer password is encrypted and customer details are stored
	 * @param CustomerDto customerDto
	 * @return CustomerDto customerDetDto
	 */
	public CustomerDto customerRegister(CustomerDto customerDto) {
		if(customerRepository.findByEmail(customerDto.getCustomerEmail()) == null) {
			String encryptedPw = bCryptPasswordEncoder.encode(customerDto.getCustomerPassword());
			Customer customer = customerMapping.toCustomerEntity(customerDto);
			customerDto.setCustomerPassword(encryptedPw);
			CustomerDto customerDetDto = customerMapping.toCustomerDto(customerRepository.save(customer));
			return customerDetDto;
		}
		else {
			throw new UserException("Customer email already registered!");
		}
	}
	
	
	/**
	 * loginCustomer() -> This method is for customer login. 
	 * If email is not present in database then exception "email not present" is thrown.
	 * else password provided is matched with encrypted password, 
	 * if they do not match throw exception "incorrect password"
	 * @param String email
	 * @param String password
	 * @return CustomerDto dto
	 */
	public CustomerDto loginCustomer(String email, String password){
		Customer customer = customerRepository.findByEmail(email);
		if(customer == null) {
			throw new UserException("Email is not present");
		}
		CustomerDto dto = customerMapping.toCustomerDto(customer);
		String pw = customer.getCustomerPassword();
		if(bCryptPasswordEncoder.matches(password, pw)) return dto;
		else throw new UserException("Incorrect Password");
	}
	
	/**
	 * updateProfilePic() -> This method is for updating the customer photo.
	 * @param byte[] bytes
	 * @param int custId
	 */
	public void updateProfilePic(byte[] bytes, int custId) {
		customerRepository.updateProfilePic(bytes, custId);
	}

	/**
	 * updateCustomerInfo() -> This method is for updating the customer details.
	 * @param Customer customer
	 * @return Customer customerDet
	 */
	public Customer updateCustomerInfo(Customer customer) {
		Customer customerDet = customerRepository.save(customer);
		return customerDet;
	}
	
}
