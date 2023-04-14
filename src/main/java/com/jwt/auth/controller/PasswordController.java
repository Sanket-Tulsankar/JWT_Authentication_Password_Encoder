package com.jwt.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.auth.entities.JwtAuthEntity;
import com.jwt.auth.entities.User;
import com.jwt.auth.exceptionHandler.NotFoundException;
import com.jwt.auth.services.PasswordService;

@RestController
public class PasswordController {

	@Autowired
	private PasswordService passwordService;
	
	@PostMapping("/usernamepass")
	public ResponseEntity<?> usernamePass(@RequestBody JwtAuthEntity jwtAuthEntity) throws Exception{
		this.passwordService.createUser(jwtAuthEntity);
		return new ResponseEntity<String>("Added successfully !!",HttpStatus.CREATED);
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<User> getUser(String username) throws Exception{
		User user = this.passwordService.readUser(username);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<String> validateUser(@RequestBody JwtAuthEntity jwtAuthEntity)throws NotFoundException{
		String string = this.passwordService.validateUser(jwtAuthEntity);
		return new ResponseEntity<String>(string,HttpStatus.FOUND);
	}
}
