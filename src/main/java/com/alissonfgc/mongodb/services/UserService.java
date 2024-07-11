package com.alissonfgc.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alissonfgc.mongodb.domain.User;
import com.alissonfgc.mongodb.repository.UserRepository;
import com.alissonfgc.mongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> usr = repo.findById(id);
		return usr.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
}
