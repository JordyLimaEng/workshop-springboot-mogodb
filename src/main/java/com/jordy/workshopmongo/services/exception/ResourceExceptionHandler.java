package com.jordy.workshopmongo.services.exception;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler implements Serializable{
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus st= HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), st.value(), "Não encontrado ", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(st).body(err);
	}
}
