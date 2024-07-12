package com.alissonfgc.mongodb.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alissonfgc.mongodb.domain.Post;
import com.alissonfgc.mongodb.repository.PostRepository;
import com.alissonfgc.mongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}

	public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
		maxDate.plusDays(1);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
