package com.sisyphusWeb.webService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sisyphusWeb.webService.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, String>{
	
}
