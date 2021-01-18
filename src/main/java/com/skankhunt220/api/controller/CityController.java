package com.skankhunt220.api.controller;

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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {
	private final CityService cityService;
	
	@PostMapping
	public ResponseEntity<City> create(@RequestBody City city) {
		return cityService.create(city);
	}

	@GetMapping("/{id}")
	public ResponseEntity<City> read(@PathVariable("id") String id) {
		return cityService.read(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<City> update(@PathVariable("id") String id, @RequestBody City city) {
		return cityService.update(id, city);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		cityService.delete(id);
	}
}