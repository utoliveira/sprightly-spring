package com.higor.springsecurityjwt.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class AuthResponse {

	@Getter
	private final String token;
	
}
