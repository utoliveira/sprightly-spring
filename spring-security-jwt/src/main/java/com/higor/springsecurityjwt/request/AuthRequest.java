package com.higor.springsecurityjwt.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

	@Getter @Setter
	private String username;
	
	@Getter @Setter
	private String password;
	
}
