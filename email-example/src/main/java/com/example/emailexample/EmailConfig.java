package com.example.emailexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public class EmailConfig {

	@Getter @Setter
	@Value("${spring.mail.host}")
	private String host;

	@Getter @Setter
	@Value("${spring.mail.username}")
	private String username;
	
	@Getter @Setter
	@Value("${spring.mail.password}")
	private String password;
	
	@Getter @Setter
	@Value("${spring.mail.port}")
	private int port;
}
