package com.example.emailexample;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

public class Feedback {

	@NotEmpty
	@Getter @Setter
	private String name;
	
	@NotEmpty
	@Getter @Setter
	private String email;
	
	@NotEmpty
	@Getter @Setter
	private String feedback;
}
