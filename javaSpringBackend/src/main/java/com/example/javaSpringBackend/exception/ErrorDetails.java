package com.example.javaSpringBackend.exception;

import java.util.Date;
/*
 * To use ErrorDetails to return the error response, 
 * let’s create a GlobalExceptionHandler class annotated with @ControllerAdvice annotation.
 * This class handles exception specific and global exception in a single place.
 * */
public class ErrorDetails {

	private Date timestamp;
	private String message;
	private String details;
	
	// Constructor
	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	// Getters
	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
}
