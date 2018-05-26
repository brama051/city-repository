package com.brama.cityrepository.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.brama.cityrepository.model.City;
import com.brama.cityrepository.repository.CityRepository;
import com.brama.cityrepository.service.CityService;
import com.brama.cityrepository.service.UserService;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	UserService userService;
	
	@Override
	public City saveNewCity(String name, String description, Long population) {
		if (!cityRepository.existsById(name)) {
			City newCity = new City(name, description, population);
			return cityRepository.save(newCity);
		}
		return null;
	}

	@Override
	public List<City> getAllOrderByTimeCreated() {
		return cityRepository.findAll(new Sort(Sort.Direction.ASC, "created"));
	}

	@Override
	public List<City> getAllOrderByFavorites() {
		return cityRepository.findAll(new Sort(Sort.Direction.ASC, "favorited"));
	}

	@Override
	public List<City> getAll() {
		return cityRepository.findAll();
	}

	@Override
	public void favorite(String cityName) {
		if (cityRepository.existsById(cityName)) {
			userService.favoriteCity(cityName);
		}
	}

	@Override
	public void unfavorite(String cityName) {
		if (cityRepository.existsById(cityName)) {
			userService.unfavoriteCity(cityName);
		}
	}

}
