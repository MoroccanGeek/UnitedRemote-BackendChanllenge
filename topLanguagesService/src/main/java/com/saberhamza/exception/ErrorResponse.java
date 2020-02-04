package com.saberhamza.exception;

/**
 * This class describes the error format returned.
 * 
 * @author Hamza SABER
 *
 */
public class ErrorResponse{
	
	/**
	 * Response code.
	 */
	private int status;
	
	/**
	 * Error message.
	 */
	private String message;
	
	/**
	 * Time when this error occured.
	 */
	private long timeStamp;

	/**
	 * no-args constructor
	 */
	public ErrorResponse() {
		
	}

	/**
	 * Constructor for ErrorResponse class.
	 * 
	 * @param status Response code
	 * @param message Error message
	 * @param timeStamp Time when this error occured
	 */
	public ErrorResponse(int status, String message, long timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	/*
	 * Getters ans Setters
	 */
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
