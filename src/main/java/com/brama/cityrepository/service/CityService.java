package com.brama.cityrepository.service;

import java.util.List;

import com.brama.cityrepository.model.City;

public interface CityService {

	public City saveNewCity(String name, String description, Long population);

	public List<City> getAllOrderByTimeCreated();

	public List<City> getAllOrderByFavorites();

	public List<City> getAll();

	public void favorite(String cityName);

	public void unfavorite(String cityName);

}
