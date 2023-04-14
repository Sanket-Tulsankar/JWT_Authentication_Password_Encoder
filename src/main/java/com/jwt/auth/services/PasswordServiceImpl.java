package com.jwt.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.auth.entities.JwtAuthEntity;
import com.jwt.auth.entities.User;
import com.jwt.auth.exceptionHandler.NotFoundException;
import com.jwt.auth.repository.UserRepo;

@Service
public class PasswordServiceImpl implements PasswordService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User readUser(String username) throws NotFoundException
	{
		User user;
		try {
			user = this.userRepo.findByUsername(username);
		} catch (Exception e) 
		{
			throw new NotFoundException("User does not exists !!");
		}
		
		return user;
	}

	@Override
	public void createUser(JwtAuthEntity jwtAuthEntity) throws Exception 
	{
		User user=new User();
		user.setUsername(jwtAuthEntity.getUsername());
		user.setPassword(passwordEncoder.encode(jwtAuthEntity.getPassword()));
		this.userRepo.save(user);
	}

	@Override
	public String validateUser(JwtAuthEntity jwtAuthEntity) throws NotFoundException
	{
		User user = this.userRepo.findByUsername(jwtAuthEntity.getUsername());
		System.out.println(user);
		if(user.getPassword().equals(jwtAuthEntity.getPassword())) 
		{
			return "User with username : "+jwtAuthEntity.getUsername()+" is present";
		}
		else 
		{
			throw new NotFoundException("User with "+jwtAuthEntity.getUsername()+" is not present");
		}
	}
}
