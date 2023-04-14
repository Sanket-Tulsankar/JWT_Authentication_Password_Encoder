package com.jwt.auth.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> notFoundException(NotFoundException ex){
		String msg=ex.exceptionMsg;
		return new ResponseEntity<String>(msg,HttpStatus.NOT_FOUND);
	}
}
