package com.sisyphusWeb.webService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisyphusWeb.webService.model.table.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, String>{

	Track findByName(String name);
	
}
