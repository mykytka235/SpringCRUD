package com.skankhunt220.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cities")
public class City {
	private @Id String id;
	private String name;
	private String zipCode;
		
	public City(String name, String zipCode) 
	{
		this.name = name;
		this.zipCode = zipCode;
	}
}
