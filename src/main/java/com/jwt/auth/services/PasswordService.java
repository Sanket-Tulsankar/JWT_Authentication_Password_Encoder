package com.jwt.auth.services;

import com.jwt.auth.entities.JwtAuthEntity;
import com.jwt.auth.entities.User;
import com.jwt.auth.exceptionHandler.NotFoundException;

public interface PasswordService 
{
	public User readUser(String username) throws NotFoundException;
	
	public void createUser(JwtAuthEntity jwtAuthEntity) throws Exception;

	public String validateUser(JwtAuthEntity jwtAuthEntity) throws NotFoundException;
}
