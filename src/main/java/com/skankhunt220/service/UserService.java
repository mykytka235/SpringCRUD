package com.skankhunt220.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skankhunt220.entity.User;
import com.skankhunt220.repository.user.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<User> createUser(User user) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(userRepository.save(new User(user.getFirstName(), user.getMiddleName(), user.getLastName())));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	public ResponseEntity<User> readUser(String userId) {
		Optional<User> userData = userRepository.findById(userId);
		if (userData.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(userData.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	public ResponseEntity<User> updateUser(String userId, User user) {
		Optional<User> userData = userRepository.findById(userId);

		if (userData.isPresent()) {
			userData.get().setFirstName(user.getFirstName());
			userData.get().setMiddleName(user.getMiddleName());
			userData.get().setLastName(user.getLastName());
			return ResponseEntity.status(HttpStatus.OK).body(userData.get());

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	public void deleteUser(String userId) {
		try {
			userRepository.deleteById(userId);
		} catch (Exception e) {}
	}
}