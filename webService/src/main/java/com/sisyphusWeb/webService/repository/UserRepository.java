package com.sisyphusWeb.webService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisyphusWeb.webService.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByName(String name);
	
	public boolean existsByName(String name);
}
