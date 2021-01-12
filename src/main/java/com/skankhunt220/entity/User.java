package com.skankhunt220.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
	private @Id String id;
	private String firstName;
	private String middleName;
	private String lastName;	
	
	public User(String firstName, String middleName, String lastName) 
	{
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
}