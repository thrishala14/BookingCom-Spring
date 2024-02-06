package com.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.entities.EmailDetails;
import com.booking.services.EmailService;

@RestController
@CrossOrigin(origins = "*")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	 
	@PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails details)
    {
        String status = emailService.sendSimpleMail(details);
        return status;
    }
}
