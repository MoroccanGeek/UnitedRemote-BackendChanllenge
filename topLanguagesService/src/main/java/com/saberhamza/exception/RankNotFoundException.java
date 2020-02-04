package com.saberhamza.exception;

/**
 * Exception class when rank is not found.
 * 
 * @author Hamza SABER
 *
 */
public class RankNotFoundException extends RuntimeException {

	public RankNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public RankNotFoundException(String arg0) {
		super(arg0);
	}

	public RankNotFoundException(Throwable arg0) {
		super(arg0);
	}
}