package com.skankhunt220.service;

import static com.skankhunt220.api.transformer.Transformer.transform;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skankhunt220.entity.City;
import com.skankhunt220.repository.city.CityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CityService {
	private final CityRepository cityRepository;

	public ResponseEntity<City> create(City city) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(cityRepository.save(City.builder().name(city.getName()).zipCode(city.getZipCode()).build()));
	}

	public ResponseEntity<City> read(String cityId) {
		return ResponseEntity.status(HttpStatus.OK).body(cityRepository.findById(cityId).get());
	}

	public ResponseEntity<City> update(String cityId, City city) {
		return ResponseEntity.status(HttpStatus.OK).body(cityRepository.save(transform(city, cityId)));
	}

	public void delete(String cityId) {
		cityRepository.deleteById(cityId);
	}
}
