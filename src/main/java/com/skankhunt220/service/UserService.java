package com.skankhunt220.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skankhunt220.entity.User;
import com.skankhunt220.repository.user.UserRepository;
import static com.skankhunt220.api.transformer.Transformer.transform;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	public ResponseEntity<User> create(User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(User.builder()
				.firstName(user.getFirstName()).middleName(user.getMiddleName()).lastName(user.getLastName()).build()));
	}

	public ResponseEntity<User> read(String userId) {
		return ResponseEntity.status(HttpStatus.OK).body(userRepository.findById(userId).get());
	}

	public ResponseEntity<User> update(String userId, User user) {
		return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(transform(user, userId)));
	}

	public void delete(String userId) {
		userRepository.deleteById(userId);
	}
}