package com.sisyphusWeb.webService.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisyphusWeb.webService.model.table.Coordinate;
import com.sisyphusWeb.webService.model.table.Track;
import com.sisyphusWeb.webService.repository.TrackRepository;

@Service
public class TrackService {
	
	@Autowired
	private TrackRepository trackRepo;
	
	public void addTrack(List<String> directories, String fullFileName, String username) {
		
//		String converterLocation = directories.get(0);
		String previewDirectory = directories.get(1);
		String thetaRhoDirectory = directories.get(2);
		
		Track track = new Track();
		
		String id = UUID.randomUUID().toString();
		track.setId(id);
		
		String type = "track";
		track.setType(type);
		
		String name = fullFileName.split("\\.")[0];
		track.setName(name);
		
		String created_by_name = username;
		track.setCreated_by_name(created_by_name);
		
		String preview_location = previewDirectory;
		track.setPreview_location(preview_location);
		
		ArrayList<Coordinate> coordinates = (ArrayList<Coordinate>) setTrackCoordinates(thetaRhoDirectory);
		track.setCoordinates(coordinates);
		
		String coordinateString = addTrackString(coordinates);
		track.setCoordinateString(coordinateString);
		
		
		
	}
	
	public Track getTrack(String id) {
		return trackRepo.findById(id).get();
	}
	
	public List<Coordinate> setTrackCoordinates(String location) {
    	File file = new File(location);
    	
    	Scanner input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	ArrayList<Coordinate> coordinates= new ArrayList<>();
    	
    	while(input.hasNext()) {
    		float rho = input.nextFloat();
    		float theta = input.nextFloat();
    		
    		Coordinate coordinate = new Coordinate(rho, theta);
    		coordinates.add(coordinate);
    	}
    	
    	input.close();
    	
    	// TODO delete coordinate thr here
    	
    	return coordinates;
    }
	
	public String addTrackString(List<Coordinate> coordinates) {
		StringBuilder trackString = new StringBuilder();
		for(Coordinate coordinate : coordinates) trackString.append(coordinate.getRho() + " " + coordinate.getTheta() + "\n");
		
		return trackString.toString();
	}
}
