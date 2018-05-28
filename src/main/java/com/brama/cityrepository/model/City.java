package com.brama.cityrepository.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.assertj.core.util.Strings;

import com.brama.cityrepository.model.listener.CityListener;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@EntityListeners(CityListener.class)
public class City implements Serializable {
	
	private static final long serialVersionUID = -1239425252515560834L;

	@Id
	private String name;
	
	private String description;
	
	private Long population;
	
	@JsonIgnore
	private LocalDateTime created;
	
	@JsonIgnore
	private Long favorited;

	public City() {
	}
	
	public City(String name, String description, Long population) {
		this();
		this.setName(name);
		this.setDescription(description);
		this.setPopulation(population);
	}
	
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

	public LocalDateTime getTimestamp() {
		return created;
	}

	public void setTimestamp(LocalDateTime created) {
		this.created = created;
	}

	public Long getFavorited() {
		return favorited;
	}

	public void setFavorited(Long favorited) {
		this.favorited = favorited;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof City) {
			City cObj = (City) obj;
			if (cObj != null && !Strings.isNullOrEmpty(cObj.getName()) && cObj.getName().equals(this.name)) {
				return true;
			}
		}
		return false;
	}
	
	
}
