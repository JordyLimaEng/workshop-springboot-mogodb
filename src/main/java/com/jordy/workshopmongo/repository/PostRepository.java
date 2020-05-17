package com.jordy.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.jordy.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{ 'title' : { $regex: ?0, $options: 'i'}}") // query para o mongodb, já implementa automaticamente de acordo com a expressão
				// regular... '?0' indica para pegar o primeiro parametro e 'i' ignora maisculas e minusculas
	List<Post> searchTitle(String text);

	List<Post> findByTitleContainingIgnoreCase(String text);
	// busca utilizando query methods, só esta declaração já faz o spring data
	// montar a consulta
	// modificando o nome da função colocando 'IgnoreCase' deixa de casesensitive
}// tudo do crud ja esta imbutido no mongorepository