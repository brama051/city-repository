package com.brama.cityrepository.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
	
	@Id
	String name;
	
	String description;
	
	Long population;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}
}
