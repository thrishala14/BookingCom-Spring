package com.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.booking.entities.EmailDetails;

@Service
public class EmailService {
	
	@Autowired
	private MailSender mailSender;
	 
	/**
	 * String sender -> the sender of the mail.
	 */
    @Value("${spring.mail.username}") 
    private String sender;
    
    
    /**
     * sendSimpleMail() -> This method is for sending a simple mail.
     * @param EmailDetails emailDet
     * @return String
     */
	public String sendSimpleMail(EmailDetails emailDet) {
		try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
 
            mailMessage.setFrom(sender);
            mailMessage.setTo(emailDet.getRecipient());
            mailMessage.setText(emailDet.getMsgBody());
            mailMessage.setSubject(emailDet.getSubject());
            
            mailSender.send(mailMessage);

            return "Mail Sent Successfully";
        }
        catch (Exception e) {
            return e.getMessage();
        }
	}

}
