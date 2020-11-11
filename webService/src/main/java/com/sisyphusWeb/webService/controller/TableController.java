package com.sisyphusWeb.webService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sisyphusWeb.webService.model.table.Pause;
import com.sisyphusWeb.webService.model.table.Play;
import com.sisyphusWeb.webService.model.table.Table;
import com.sisyphusWeb.webService.model.table.Time;
import com.sisyphusWeb.webService.model.table.Track;
import com.sisyphusWeb.webService.service.TableService;

@CrossOrigin
@RestController
public class TableController {
	 @Autowired
	 private TableService tableService;
	 
	 @GetMapping("/play")
	 public Play playTable() {
	   	return tableService.play();
	 }
	    
	 @GetMapping("/pause")
	 public Pause pauseTable() {
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
	 public Time getTime() {
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
}
