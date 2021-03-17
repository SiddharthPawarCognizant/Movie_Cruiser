package com.movie_cruiser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movie_cruiser.HelperJWT.JwtUtil;
import com.movie_cruiser.JWT.Method.JwtRequest;
import com.movie_cruiser.JWT.Method.JwtResponse;
import com.movie_cruiser.service.CustomerDetailsService;



@RestController
@CrossOrigin
public class TokenController {
	
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private  AuthenticationManager authenticationManager;
	
	
	@RequestMapping(value="/token",method=RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
          System.out.println(jwtRequest);
		try{
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		}catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("bad Credentials");
		}
		UserDetails userDetails=this.customerDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token=this.jwtUtil.generateToken(userDetails);
		System.out.println("Jwt"+token);
		
		
		return ResponseEntity.ok(new JwtResponse(token));
	}

}
