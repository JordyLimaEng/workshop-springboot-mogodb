package com.jordy.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordy.workshopmongo.domain.User;
import com.jordy.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired//o proprio spring procura a declaração do objeto e já declara aqui
	private UserRepository repo;
	
	public List<User> findAll(){//varias funções já vem implementadas no springdata
		return repo.findAll();//exemplo de função do springdata
	}
}
