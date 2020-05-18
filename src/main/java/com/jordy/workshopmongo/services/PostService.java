package com.jordy.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordy.workshopmongo.domain.Post;
import com.jordy.workshopmongo.repository.PostRepository;
import com.jordy.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired // o proprio spring procura a declaração do objeto e já declara aqui
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String title){
		//return repo.findByTitleContainingIgnoreCase(title);
		return repo.searchTitle(title);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}

	
}