package com.skankhunt220.api.transformer;

import com.skankhunt220.api.dto.CityDto;
import com.skankhunt220.entity.City;

public class CityTransformer {
	
	public static CityDto transform(City city ,String id) {
		return CityDto.builder()
				.id(id)
				.name(city.getName())
				.zipCode(city.getZipCode())
				.build();	
	}
	
	public static City transform(CityDto city, String id) {
		return City.builder()
				.id(id)
				.name(city.getName())
				.zipCode(city.getZipCode())
				.build();	
	}
}
