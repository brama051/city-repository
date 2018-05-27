package com.brama.cityrepository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brama.cityrepository.model.User;

public interface UserRepository extends JpaRepository<User, String> {	
}
