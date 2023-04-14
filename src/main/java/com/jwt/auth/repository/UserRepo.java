package com.jwt.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.auth.entities.User;
import com.jwt.auth.exceptionHandler.NotFoundException;

public interface UserRepo extends JpaRepository<User, Long>{

	public User findByUsername(String username) throws NotFoundException;
}
