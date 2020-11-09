package com.sisyphusWeb.webService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sisyphusWeb.webService.model.table.Queue;
import com.sisyphusWeb.webService.model.table.Track;
import com.sisyphusWeb.webService.repository.QueueRepository;

public class QueueService {

	@Autowired
	private QueueRepository queueRepo;
	
	public List<Queue> returnQueue() {
		return queueRepo.findAll();
	}

	public void addToQueue(int lastId, Track track) {
		Queue queue = new Queue(lastId, track);
		queueRepo.save(queue);
	}
	
	public void addToFrontofQueue() {
		
	}
	
	public void removeFromQueue() {
		
	}
	
	public void removeFromEndofQueue() {
		
	}
}
