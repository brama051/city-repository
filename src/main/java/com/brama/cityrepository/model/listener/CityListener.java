package com.brama.cityrepository.model.listener;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;

import com.brama.cityrepository.model.City;

public class CityListener {
	@PrePersist
	public void prePersist(City city) {
		city.setTimestamp(LocalDateTime.now());
		city.setFavorited(0L);
	}
}
