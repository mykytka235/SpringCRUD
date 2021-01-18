package com.skankhunt220.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.skankhunt220.repository.city", mongoTemplateRef = "secondaryMongoTemplate")
public class CityAutoConfiguration {

}