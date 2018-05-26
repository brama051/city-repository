package com.brama.cityrepository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brama.cityrepository.model.City;

public interface CityRepository extends JpaRepository<City, String> {
	
}
