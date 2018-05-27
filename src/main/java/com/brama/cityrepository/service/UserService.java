package com.brama.cityrepository.service;

import com.brama.cityrepository.model.User;

public interface UserService {
	
	User registerNewUser(String email, String password);
	
	User login(String email, String password);
	
	boolean emailExists(String email);
	
	void favoriteCity(String cityName, String username);
	
	void unfavoriteCity(String cityName, String username);
}
