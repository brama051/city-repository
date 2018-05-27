package com.brama.cityrepository.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {
	@Id
	String email;
	
	String password;

	@ManyToMany
	Set<City> favoriteCities;
	
	public User() {
		favoriteCities = new HashSet<>();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<City> getFavoriteCities() {
		return favoriteCities;
	}

	public void setFavoriteCities(Set<City> favoriteCities) {
		this.favoriteCities = favoriteCities;
	}
}
