package com.example.emailexample;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController{

	@Autowired
	private EmailConfig emailConfig;

	@PostMapping
	public void sendFeedback(@RequestBody Feedback feedback, BindingResult validationResult) {

		if(validationResult.hasErrors()) {throw new ValidationException("Feedback not valid");}
		
		
		//Create mail sender
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(emailConfig.getHost());
		mailSender.setPort(emailConfig.getPort());
		mailSender.setPassword(emailConfig.getPassword());
		mailSender.setUsername(emailConfig.getUsername());
		
		//Create mail instance
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(feedback.getEmail());
		mailMessage.setTo("fakeemail@email.com");
		mailMessage.setSubject("Testandinho feedback de " +feedback.getName());
		mailMessage.setText(feedback.getFeedback());
		
		//Send the email
		mailSender.send(mailMessage);
	}

}
