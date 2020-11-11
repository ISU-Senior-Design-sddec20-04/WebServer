package com.sisyphusWeb.webService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisyphusWeb.webService.model.table.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, String>{

	Track findByName(String name);
	
//	List<Track> findAllByCreated_by_name(String created_by_name);
}
