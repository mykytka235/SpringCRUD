package com.skankhunt220.repository;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.skankhunt220.entity.User;

@Repository
public class UserRepository {
	private MongoTemplate mongoTemplate = new MongoTemplate(MongoClients.create("mongodb://localhost:27017"), "UserDB");
	private MongoCollection<Document> collection = mongoTemplate.getCollection("users");

	public void create(User user) {
		collection.insertOne(new Document("_id", new ObjectId()).append("firstName", user.getFirstName())
				.append("middleName", user.getMiddleName()).append("lastName", user.getLastName()));
	}

	public Document read(String userId) {
		return collection.find(eq("_id", new ObjectId(userId))).first();
	}

	public void update(User user) {
		collection.updateOne(eq("_id", new ObjectId(user.getId())),
				new Document("$set", new Document("firstName", user.getFirstName())
						.append("middleName", user.getMiddleName()).append("lastName", user.getLastName())));
	}

	public void delete(String userId) {
		collection.deleteOne(eq("_id", new ObjectId(userId)));
	}
}
