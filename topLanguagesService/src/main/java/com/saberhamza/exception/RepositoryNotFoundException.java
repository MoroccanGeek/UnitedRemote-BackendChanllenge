package com.saberhamza.exception;

/**
 * Exception class when repository not found.
 * 
 * @author Hamza SABER
 *
 */
public class RepositoryNotFoundException extends RuntimeException{

	public RepositoryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepositoryNotFoundException(String message) {
		super(message);
	}

	public RepositoryNotFoundException(Throwable cause) {
		super(cause);
	}
	
}