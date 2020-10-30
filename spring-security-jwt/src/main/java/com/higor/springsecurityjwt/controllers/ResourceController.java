package com.higor.springsecurityjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.higor.springsecurityjwt.request.AuthRequest;
import com.higor.springsecurityjwt.response.AuthResponse;
import com.higor.springsecurityjwt.util.JwtUtil;

@RestController	
public class ResourceController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/hello")
	public String getHello() {
		return "Hello";
	}
	
	@PostMapping(path = "/auth")
	public ResponseEntity<?> auth(@RequestBody AuthRequest request) throws Exception {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		}catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		/*Aqui a autenticação é successfull*/
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		final String token = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthResponse(token));
	
	}
	
}
