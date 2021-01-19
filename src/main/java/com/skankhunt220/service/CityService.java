
package com.skankhunt220.service;

import org.springframework.stereotype.Service;

import com.skankhunt220.entity.City;
import com.skankhunt220.repository.city.CityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CityService {
	private final CityRepository cityRepository;

	public City create(City city) {
		return cityRepository.save(city);
	}

	public City read(String cityId) {
		return cityRepository.findById(cityId).get();
	}

	public City update(City city) {
		return cityRepository.save(city);
	}

	public void delete(String cityId) {
		cityRepository.deleteById(cityId);
	}
}