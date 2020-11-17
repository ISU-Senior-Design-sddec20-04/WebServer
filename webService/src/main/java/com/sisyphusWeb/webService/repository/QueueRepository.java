package com.sisyphusWeb.webService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisyphusWeb.webService.model.table.QueueItem;

@Repository
public interface QueueRepository extends JpaRepository<QueueItem, Long>{
	QueueItem findByTrackId(String trackId);
	
	boolean existsByTrackId(String trackId);
}
