package com.brama.cityrepository.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.brama.cityrepository.model.User;
import com.brama.cityrepository.repository.CityRepository;
import com.brama.cityrepository.repository.UserRepository;
import com.brama.cityrepository.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	@Value("${security.encoding-strength}")
	private Integer encodingStrength;
	
	@Transactional
	public User registerNewUser(String email, String password) {
		if (!emailExists(email)) {
			BCryptPasswordEncoder bc = new BCryptPasswordEncoder(this.encodingStrength);
			
			User user = new User();
			user.setEmail(email);
			user.setPassword(bc.encode(password));
			
			return userRepository.save(user);
		}
		
		return null;
	}

	@Override
	public User login(String email, String password) {
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder(this.encodingStrength);
		
		Optional<User> optionalUser = userRepository.findById(email);
		if (optionalUser.isPresent() && bc.matches(password, optionalUser.get().getPassword())) {
			return optionalUser.get();
		}
		return null;
	}

	@Override
	public boolean emailExists(String email) {
		return userRepository.existsById(email);
	}

	@Override
	public void favoriteCity(String cityName, String username) {
		User user = userRepository.findById(username).get();
		user.getFavoriteCities().add(cityRepository.findById(cityName).get());
	}

	@Override
	public void unfavoriteCity(String cityName, String username) {
		User user = userRepository.findById(username).get();
		user.getFavoriteCities().remove(cityRepository.findById(cityName).get());
	}

}
