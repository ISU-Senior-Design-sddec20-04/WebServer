package com.sisyphusWeb.webService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sisyphusWeb.webService.model.table.Table;
import com.sisyphusWeb.webService.model.table.Track;
import com.sisyphusWeb.webService.payload.PauseResponse;
import com.sisyphusWeb.webService.payload.PlayResponse;
import com.sisyphusWeb.webService.payload.TimeResponse;
import com.sisyphusWeb.webService.service.QueueService;
import com.sisyphusWeb.webService.service.TableService;

@CrossOrigin
@RestController
public class TableController {
	 @Autowired
	 private TableService tableService;
	 
	 @Autowired
	 private QueueService queueService;
	 
	 @GetMapping("/play")
	 public PlayResponse playTable() {
	   	return tableService.play();
	 }
	    
	 @GetMapping("/pause")
	 public PauseResponse pauseTable() {
	  	return tableService.pause();
	 }
	 
	 @GetMapping("/connect")
	 public Table connectTable() {
		 return tableService.getInfo();
	 }
	 
	 @GetMapping("/active") 
	 public Track getActiveTrack() {
		 return tableService.getActiveTrack();
	 }
	 
	 @GetMapping("/updateDB")
	 public String updateDatabase() {
		 tableService.initTrackDB();
		 return "Done";
	 }
	 
	 @GetMapping("/setTrack")
	 public Track setTrack(@RequestParam String name) {
		 return tableService.set_track(name);
	 }
	 
	 @GetMapping("/getTime")
	 public TimeResponse getTime() {
		 return tableService.getTrackTime();
	 }
	 
	 @GetMapping("/setLoop")
	 public boolean setLoop(@RequestParam boolean bool) {
		 return tableService.set_loop(bool);
	 }
	 
	 @GetMapping("/isCurrentTrackLooping")
	 public boolean isCurrentTrackLooping() {
		 return tableService.isLooping();
	 }
	 
	 @GetMapping("/openStream")
	 public String startStream() {
		 return tableService.start_streaming();
	 }
	 
	 @GetMapping("/sendClear")
	 public String sendClear(@RequestParam String streamId) {
		queueService.sendClear(streamId);
		return "Clear sent";
	 }
	 
	 @GetMapping("/sendTrack") 
	 public String sendTrack(@RequestParam String streamId, @RequestParam String trackId) {
		 queueService.sendTrack(streamId, trackId);
		 return "Track " + trackId + " sent";
	 }
	 
	 @GetMapping("/sendTrackByCoords")
	 public String sendTrackByCoords(@RequestParam String streamId, @RequestParam String trackId) {
		 queueService.sendTrackByCoord(streamId, trackId);
		 return "Track " + trackId + " sent";
	 }
	 
	 @GetMapping("/closeStream")
	 public String stopStream(@RequestParam String streamId) {
		 tableService.stop_streaming(streamId);
		 return "Stream stopped";
	 }
}
