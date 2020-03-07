package com.example.javaSpringBackend.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/*
 * The @ControllerAdvice annotation 
 * allows you to handle exceptions across the whole application, 
 * not just to an individual controller. 
 * You can think of it as an interceptor of exceptions thrown by methods annotated with
 * @RequestMapping or one of the shortcuts.
 * */
@ControllerAdvice
public class GlobalExceptionHandler {

	/*
	 * To handle exceptions in String MVC, 
	 * we can define a method in controller class and use the annotation @ExceptionHandler on it. 
	 * Spring configuration will detect this annotation and register the method as exception handler
	 * for argument exception class and its subclasses.
	 * */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> ressourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
		ErrorDetails details = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception exception, WebRequest request) {
		ErrorDetails details = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
