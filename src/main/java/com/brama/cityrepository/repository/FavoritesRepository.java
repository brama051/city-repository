package com.brama.cityrepository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brama.cityrepository.model.Favorites;

public interface FavoritesRepository extends JpaRepository<Favorites, String>{
	
}
