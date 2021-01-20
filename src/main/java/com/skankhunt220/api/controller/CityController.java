package com.skankhunt220.api.controller;

import static com.skankhunt220.api.transformer.CityTransformer.transform;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skankhunt220.api.dto.CityDto;
import com.skankhunt220.entity.City;
import com.skankhunt220.service.CityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {
	private final CityService cityService;
	
	@PostMapping
	public CityDto create(@RequestBody CityDto cityDto) {
		City city = transform(cityDto, cityDto.getId());
		return transform(cityService.create(city), city.getId());
	}

	@GetMapping("/{id}")
	public CityDto getCity(@PathVariable("id") String id) {
		return transform(cityService.getById(id), id);
	}

	@PutMapping("/{id}")
	public CityDto update(@PathVariable("id") String id, @RequestBody CityDto city) {
		return transform(cityService.update(transform(city, id)), id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		cityService.delete(id);
	}
}