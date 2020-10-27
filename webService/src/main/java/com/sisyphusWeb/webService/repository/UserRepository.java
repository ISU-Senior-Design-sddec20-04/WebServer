package com.sisyphusWeb.webService.repository;

import org.springframework.data.repository.CrudRepository;

import com.sisyphusWeb.webService.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
