package com.brama.cityrepository.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brama.cityrepository.model.User;
import com.brama.cityrepository.service.AuthenticationService;
import com.brama.cityrepository.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuthenticationService authenticationService;
		
	
	@PostMapping("/register")
	public ResponseEntity<?> registerNewUser(@RequestParam("email") String email, @RequestParam("password") String password) {
		User user = userService.registerNewUser(email, password);
		if (user != null) {
			Map<String, String> response = authenticationService.createAuthenticationRequest(email, password);
			return new ResponseEntity<String>("Bearer " + response.get("access_token"), HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("User already exists", HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam("email") String email, @RequestParam("password") String password) {
		User user = userService.login(email, password);
		if (user != null) {
			Map<String, String> response = authenticationService.createAuthenticationRequest(email, password);
			return new ResponseEntity<String>("Bearer " + response.get("access_token"), HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
	} 
}
