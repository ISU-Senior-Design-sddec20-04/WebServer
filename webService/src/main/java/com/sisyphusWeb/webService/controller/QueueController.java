package com.sisyphusWeb.webService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sisyphusWeb.webService.model.table.QueueItem;
import com.sisyphusWeb.webService.service.QueueService;

@RestController
public class QueueController {
	
	@Autowired
	private QueueService queueService;

	@GetMapping("/getQueue")
	public List<QueueItem> getQueue() {
		return queueService.returnQueue();
	}
	
	@PostMapping("/addToQueue")
	public String addToQueue(@RequestParam String trackId) {
		return queueService.addToQueue(trackId);
	}
	
	@PostMapping("/addToFrontOfQueue")
	public String addToFrontQueue(@RequestParam String trackId) {
		return queueService.addToFrontofQueue(trackId);
	}
	
	@DeleteMapping("/removeFromQueue")
	public String removeFromQueue(@RequestParam String trackId) {
		return queueService.removeFromQueue(trackId);
	}
	
	@GetMapping("/isCurrentTrackEraseBefore")
	public boolean isCurrentTrackEraseBefore(@RequestParam String trackId) {
		return queueService.getClear(trackId);
	}
	
	@PutMapping("/setCurrentTrackEraseBefore")
	public String SetEraseBefore(@RequestParam String trackId, @RequestParam boolean bool) {
		return queueService.setClear(trackId, bool);
	}
}
