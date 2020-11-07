package com.sisyphusWeb.webService.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisyphusWeb.webService.model.table.Coordinate;
import com.sisyphusWeb.webService.model.table.Track;
import com.sisyphusWeb.webService.repository.TrackRepository;

@Service
public class TrackService {
	
	@Autowired
	private TrackRepository trackRepo;
	
	public void addTrack() {
		
	}
	
	public Track getTrack(String id) {
		return trackRepo.findById(id).get();
	}
	
	public void setTrackCoordinates(String id, String location) throws FileNotFoundException {
    	File file = new File(location);
    	Scanner input = new Scanner(file);
    	Track track = trackRepo.findById(id).get();
    	ArrayList<Coordinate> coordinates= new ArrayList<>();
    	
    	while(input.hasNext()) {
    		float x = input.nextFloat();
    		float y = input.nextFloat();
    		Coordinate coordinate = new Coordinate(x, y);
    		coordinates.add(coordinate);
    	}
    	
    	input.close();
    	
    	track.setCoordinates(coordinates);
    }
}
