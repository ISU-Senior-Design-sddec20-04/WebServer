package com.sisyphusWeb.webService.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.sisyphusWeb.webService.model.table.Pause;
import com.sisyphusWeb.webService.model.table.Play;
import com.sisyphusWeb.webService.model.table.Playlist;
import com.sisyphusWeb.webService.model.table.Table;
import com.sisyphusWeb.webService.model.table.Time;
import com.sisyphusWeb.webService.model.table.Track;
import com.sisyphusWeb.webService.repository.TrackRepository;

@Service
public class TableService {
	private RestTemplate restTemplate;
	private final String baseURL = "http://173.20.96.222:3002/sisbot";
	
	@Autowired
	private TrackRepository trackRepo;
	
	public TableService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public Play play() {
		
		String httpURL = baseURL + "/play";

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); 
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{}");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		restTemplate = new RestTemplate();
		
		return new Gson().fromJson(new JSONObject(restTemplate.postForObject(httpURL, request, String.class)).getJSONObject("resp").toString(), Play.class);
	}
	
	public Pause pause() {
		String httpURL = baseURL + "/pause";

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); 
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{}");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		restTemplate = new RestTemplate();
		
		return new Gson().fromJson(new JSONObject(restTemplate.postForObject(httpURL, request, String.class)).getJSONObject("resp").toString(), Pause.class);
	}
	
	public JSONArray connect() {
		String httpURL = baseURL + "/connect";
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{}");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		restTemplate = new RestTemplate();
		
		return new JSONObject(restTemplate.postForObject(httpURL, request, String.class)).getJSONArray("resp");
	}
	
	public  Time getTrackTime() {
		
		String httpURL = baseURL + "/get_track_time";
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{}");
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
		
		restTemplate = new RestTemplate();
		
		return new Gson().fromJson(new JSONObject(restTemplate.postForObject(httpURL, request, String.class)).getJSONObject("resp").toString(), Time.class);
	}
	
	public Table getInfo() {
		return new Gson().fromJson(connect().getJSONObject(0).toString(), Table.class);
	}
	
	public Track getActiveTrack() {
		return getInfo().getActive_track();
	}
	
	public void initTrackDB() {
		JSONArray jsons = connect();
		
		for(int i = 1; i < jsons.length(); i++) {
			Track track = new Gson().fromJson(jsons.getJSONObject(i).toString(), Track.class);
			if(track.getType().equals("track")) {
				if(!trackRepo.existsById(track.getId())) {
					if(track.getType() == null) track.setType("track");
					if(track.getType().equals("track") && !track.getId().equals("attach") && !track.getId().equals("detach")) trackRepo.save(track);
				}
			}
		}
	}
	
	public void start_streaming() {
		
	}
	
	public void add_verts() {
		
	}
	
	public void clear_verts() {
		
	}
	
	public void stop_streaming() {
		
	}
	
	public Track get_track(String id) {
		return trackRepo.findById(id).get();
	}
	
	public Track add_track(Track track, String coordinateString) {
		
		String httpURL = baseURL + "/add_track";

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); 
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{\"data\":{\"id\":\"" + track.getId() + "\",\"type\":\""
				+ track.getType() + "\",\"name\":\""
				+ track.getName() + "\",\"verts\":\""
				+ coordinateString + "\"}}");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		restTemplate = new RestTemplate();
		
		return new Gson().fromJson(new JSONObject(restTemplate.postForObject(httpURL, request, String.class)).getJSONArray("resp").getJSONObject(0).toString(), Track.class);
	}
	
	public Track set_track(String name) {
		Track track = trackRepo.findByName(name);
		
		String httpURL = baseURL + "/set_track";

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); 
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{\"data\":{\"id\":\"" + track.getId() + "\",\"type\":\""
				+ track.getType() + "\",\"name\":\""
				+ track.getName() + "\"}}");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		restTemplate = new RestTemplate();
		
		return new Gson().fromJson(new JSONObject(restTemplate.postForObject(httpURL, request, String.class)).getJSONArray("resp").getJSONObject(0).toString(), Track.class);
	}
	
	public Playlist remove_track(String id) {

		Track track = trackRepo.findById(id).get();
		
		String httpURL = baseURL + "/remove_track";

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); 
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{\"data\":{\"id\":\"" + track.getId() + "\",\"type\":\""
				+ track.getType() + "\"}}");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		restTemplate = new RestTemplate();
		
		return new Gson().fromJson(new JSONObject(restTemplate.postForObject(httpURL, request, String.class)).getJSONArray("resp").getJSONObject(0).toString(), Playlist.class);
	}
	
	
//	@Scheduled(fixedRate=10000)
//	public void updateQueue() {
//		if(getActiveTrack().equals(null)) {
//			
//		}
//	}
}
