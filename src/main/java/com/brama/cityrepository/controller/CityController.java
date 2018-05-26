package com.brama.cityrepository.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brama.cityrepository.model.City;
import com.brama.cityrepository.service.CityService;
import com.brama.cityrepository.service.UserService;

@RestController
@RequestMapping("/cities")
public class CityController {
	
	@Autowired 
	CityService cityService;
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public City createNewCity(String name, String description, Long population) {
		return cityService.saveNewCity(name, description, population);
	}
	
	@GetMapping("{cityName}/favorite")
	public void favoriteCity(@PathVariable String cityName) {
		cityService.favorite(cityName);
	}
	
	@GetMapping("{cityName}/unfavorite")
	public void unfavoriteCity(@PathVariable String cityName) {
		cityService.unfavorite(cityName);
	}
	
	@GetMapping
	public List<City> getAll(@RequestParam(name="orderBy", required=false, defaultValue="") String orderBy) {
		switch (orderBy) {
		case "created":
			return cityService.getAllOrderByTimeCreated();
		case "favorites":
			return cityService.getAllOrderByFavorites();
		default:
			return cityService.getAll();
		}
	}
	
}
