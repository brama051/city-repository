package com.brama.cityrepository.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brama.cityrepository.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	
	@PostMapping("/register")
	public String registerNewUser(@RequestParam("email") String email, @RequestParam("password") String password) {
		userService.registerNewUser(email, password);
		// TODO: generate securety token 
		return "";
	}
	
	@PostMapping("/login")
	public void login() {
		// TODO: generate securety token 
	} 
}
