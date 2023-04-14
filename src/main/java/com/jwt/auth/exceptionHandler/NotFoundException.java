package com.jwt.auth.exceptionHandler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends Exception{
	
	public String exceptionMsg;

	public NotFoundException(String message) {
		super(message);
		this.exceptionMsg=message;
	}
}
