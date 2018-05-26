package com.brama.cityrepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.brama.cityrepository.model.City;
import com.brama.cityrepository.repository.CityRepository;

@SpringBootApplication
public class CityRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityRepositoryApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(CityRepository cityRepository) {
		return (args) -> {
			cityRepository.save(new City("Rijeka", "Grad koji tece", 150000L));
			cityRepository.save(new City("Zagreb", "Glavni grad RH", 1000000L));
			cityRepository.save(new City("Pula", "Dom arene", 800000L));
			cityRepository.save(new City("Split", "Grad pod Marjanom", 200000L));
			cityRepository.save(new City("Labin", "Nekad grad rudara, danas grad umjetnika", 30000L));
			cityRepository.save(new City("Motovun", "Grad na tartufima", 1000L));
			cityRepository.save(new City("Dubrovnik", "Skup grad", 10000L));
			cityRepository.save(new City("Opatija", "", 70000L));
			cityRepository.save(new City("Krk", "Dom Bascanske ploce", 20000L));
			cityRepository.save(new City("Cres", "Janjetina i pol", 15000L));
		};
	}
}
