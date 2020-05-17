package com.jordy.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jordy.workshopmongo.domain.Post;
import com.jordy.workshopmongo.resources.util.URL;
import com.jordy.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	// pra casar o id recebido na url com o campo, usar pathvariable
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	// como vai ser parametro ?parametro=... mudar pathvvariable para RequestParam.
	// Value mostra ao parametro para entender qual tem que procurar, no caso "text="
	// se o valor nao for informado, 'default' atribui ""
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);	
		return ResponseEntity.ok().body(list);
	}
}