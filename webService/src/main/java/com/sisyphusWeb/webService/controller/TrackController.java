package com.sisyphusWeb.webService.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sisyphusWeb.webService.model.table.Track;
import com.sisyphusWeb.webService.service.TrackService;

@CrossOrigin
@RestController
public class TrackController {
	
	private static final Logger logger = LoggerFactory.getLogger(TrackController.class);

	@Autowired
	private TrackService trackService;
	
	 @GetMapping("/getTrack")
	 public Track getTrack(@RequestParam String id) {
		 return trackService.getTrack(id);
	 }
	 
	 @GetMapping("/getAllTracks")
	 public List<Track> getAllTracks() {
		 return trackService.getAllTracks();
	 }
	 
	 @GetMapping("/getTracksByUser")
	 public List<Track> getAllTracksByUser(@RequestParam String name) {
		 return trackService.getAllTracksByUser(name);
	 }
	 
	 @GetMapping("/getTrackPreview")
	 public ResponseEntity<Resource> getTrackPreview(@RequestParam String id, HttpServletRequest request) {
		// Load file as Resource
	        Resource resource = trackService.loadTrackPreview(id);

	        // Try to determine file's content type
	        String contentType = null;
	        try {
	            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	        } catch (IOException ex) {
	            logger.info("Could not determine file type.");
	        }

	        // Fallback to the default content type if type could not be determined
	        if(contentType == null) {
	            contentType = "application/octet-stream";
	        }
//	        List<ResponseEntity.ok>
	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(contentType))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
	                .body(resource);
//		 return trackService.getTrackPreview(id);
	 }
}
