package com.sisyphusWeb.webService.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisyphusWeb.webService.model.User;
import com.sisyphusWeb.webService.model.table.Coordinate;
import com.sisyphusWeb.webService.model.table.Track;
import com.sisyphusWeb.webService.repository.TrackRepository;
import com.sisyphusWeb.webService.repository.UserRepository;

@Service
public class TrackService {
	
	@Autowired
	private TrackRepository trackRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TableService tableService;
	
	@Autowired 
	private FileStorageService fileService;
	
	@Autowired UserService userService;
	
	public Track getTrack(String id) {
		return trackRepo.findById(id).get();
	}
	
	//directory at 1st index will be the preview Directory, directory at second will be the location of the thr file, 3rd index will be the directory of the thr files
	public void addTrack(List<String> directories, String fullFileName, String username) {
		
		Track track = new Track();
		
		String uuid = UUID.randomUUID().toString();
		
		ArrayList<Coordinate> coordinates = (ArrayList<Coordinate>) setTrackCoordinates(uuid, directories.get(1));
		fileService.renameWindows(directories.get(1), uuid+".thr");
		
		//fill track with data
		track.setId(uuid);
		track.setType("track");
		track.setName(fullFileName.split("\\.")[0]);
		track.setCreated_by_name(username);
		track.setPreview_location(directories.get(0));
		track.setTheta_location(directories.get(2) + uuid+".thr");
		track.setReversible(tableService.add_track(track, addTrackString(coordinates)).isReversible());
		track.setVel(1);
		track.setAccel((float) 0.5);
		track.setThvmax(1);
		
		trackRepo.save(track);
		
		userService.addTrack(username, track.getId());
	}
	
	public String removeTrack(String id) {
		if(!trackRepo.existsById(id)) return "There is no track by this id: " + id;
		Track track = trackRepo.findById(id).get();
		fileService.deleteWindows(track.getPreview_location());
		fileService.deleteWindows(track.getTheta_location());
		trackRepo.deleteById(id);
		return "Track " + id + " has been removed";
	}
	
	public List<Coordinate> setTrackCoordinates(String uuid, String source) {
    	File file = new File(source);
    	
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
    	
    	return coordinates;
    }
	
	public String addTrackString(List<Coordinate> coordinates) {
		StringBuilder trackString = new StringBuilder();
		for(Coordinate coordinate : coordinates) trackString.append(coordinate.getRho() + " " + coordinate.getTheta() + "\\n");
		
		return trackString.toString();
	}
}
