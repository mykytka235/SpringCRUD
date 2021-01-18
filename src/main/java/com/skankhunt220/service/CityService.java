package com.skankhunt220.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skankhunt220.entity.City;
import com.skankhunt220.repository.city.CityRepository;

@Service
public class CityService {	
	@Autowired
	private CityRepository cityRepository;

	public ResponseEntity<City> createCity(City city) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(cityRepository.save(new City(city.getName(), city.getZipCode())));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	public ResponseEntity<City> readCity(String cityId) {
		Optional<City> cityData = cityRepository.findById(cityId);
		if (cityData.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(cityData.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	public ResponseEntity<City> updateCity(String cityId, City city) {
		Optional<City> cityData = cityRepository.findById(cityId);

		if (cityData.isPresent()) {
			cityData.get().setName(city.getName());
			cityData.get().setZipCode(city.getZipCode());
			return ResponseEntity.status(HttpStatus.OK).body(cityData.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	public void deleteCity(String cityId) {
		try {
			cityRepository.deleteById(cityId);
		} catch (Exception e) {}
	}
}
