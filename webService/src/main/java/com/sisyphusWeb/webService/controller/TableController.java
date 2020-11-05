package com.sisyphusWeb.webService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sisyphusWeb.webService.model.table.Connect;
import com.sisyphusWeb.webService.model.table.Pause;
import com.sisyphusWeb.webService.model.table.Play;
import com.sisyphusWeb.webService.service.TableService;

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
	 public Connect connectTable() {
		 return tableService.connect();
	 }
}
