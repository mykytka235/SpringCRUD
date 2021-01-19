package com.skankhunt220.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "com.skankhunt220.repository.city", mongoTemplateRef = "secondaryMongoTemplate")
public class CityAutoConfiguration {
	@Bean(name = "secondary")
	@ConfigurationProperties(prefix = "mongodb")
	public MongoProperties getSecondary() {
		return new MongoProperties();
	}

	@Bean(name = "secondaryMongoTemplate")
	public MongoTemplate secondaryMongoTemplate() throws Exception {
		return new MongoTemplate(secondaryFactory(getSecondary()));
	}

	@Bean
	public MongoDatabaseFactory secondaryFactory(final MongoProperties mongo) throws Exception {
		return new SimpleMongoClientDatabaseFactory(MongoClients.create(mongo.getUri()), mongo.getDatabase());
	}
}