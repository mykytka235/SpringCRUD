package com.skankhunt220.repository.city;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.skankhunt220.entity.City;
@Repository
public interface CityRepository extends MongoRepository<City, String> {}