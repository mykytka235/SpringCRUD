package com.skankhunt220.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skankhunt220.entity.City;
import com.skankhunt220.service.CityService;

@RestController
@RequestMapping("/api/cities")
public class CityController {
	@Autowired
	private CityService cityService;
	
	@PostMapping
	public ResponseEntity<City> create(@RequestBody City city) {
		return cityService.createCity(city);
	}

	@GetMapping("/{id}")
	public ResponseEntity<City> read(@PathVariable("id") String id) {
		return cityService.readCity(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<City> update(@PathVariable("id") String id, @RequestBody City city) {
		return cityService.updateCity(id, city);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		cityService.deleteCity(id);
	}
}