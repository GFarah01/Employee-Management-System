package com.example.javaSpringBackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * When an endpoint returns successfully, Spring provides an HTTP 200 (OK) response.
 * If we want to specify the response status of a controller method, 
 * we can mark that method with @ResponseStatus
 * */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
