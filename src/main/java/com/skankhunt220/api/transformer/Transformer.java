package com.skankhunt220.api.transformer;

import com.skankhunt220.entity.City;
import com.skankhunt220.entity.User;

public class Transformer {
	public static User transform(User user, String id) {
		return User.builder().id(id).firstName(user.getFirstName()).middleName(user.getMiddleName())
				.lastName(user.getLastName()).build();	
	}
	public static City transform(City city, String id) {
		return City.builder().id(id).name(city.getName()).zipCode(city.getZipCode()).build();	
	}
}
