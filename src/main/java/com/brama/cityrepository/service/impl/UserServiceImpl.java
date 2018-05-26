package com.brama.cityrepository.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brama.cityrepository.model.User;
import com.brama.cityrepository.repository.UserRepository;
import com.brama.cityrepository.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public User registerNewUser(String email, String password) {
		if (!emailExists(email)) {
			
		}
		return null;
	}

	@Override
	public boolean emailExists(String email) {
		return userRepository.existsById(email);
	}

	@Override
	public void favoriteCity(String cityName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unfavoriteCity(String cityName) {
		// TODO Auto-generated method stub
		
	}
}
