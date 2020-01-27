package com.saberhamza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundExceptionHandler {
	
	//To-Do when specified language Rank is not found
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(RankNotFoundException exc){
		
		//create a RankErrorResponse
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//return Http Response
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	
	//To-DO when specified repository is not found
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(RepositoryNotFoundException exc){
		
		//create a RankErrorResponse
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//return Http Response
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	
	//Catch any other exception
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exc){
		
		//create a RankErrorResponse
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Unrecognized endpoint");
		error.setTimeStamp(System.currentTimeMillis());
		
		//return Http Response
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}

	

}
