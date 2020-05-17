package com.jordy.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jordy.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	//busca utilizando query methods, só esta declaração já faz o spring data montar a consulta
	//modificando o nome da função colocando 'IgnoreCase' deixa de casesensitive
}//tudo do crud ja esta imbutido no mongorepository