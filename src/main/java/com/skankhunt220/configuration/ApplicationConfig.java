package com.skankhunt220.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.skankhunt220.repository")
class ApplicationConfig extends AbstractMongoClientConfiguration {
	@Override
	protected String getDatabaseName() {
		return "UsersDB";
	}
}