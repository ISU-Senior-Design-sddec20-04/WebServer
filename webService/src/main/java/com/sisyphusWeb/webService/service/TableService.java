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
import com.sisyphusWeb.webService.model.table.BallPosition;
import com.sisyphusWeb.webService.model.table.Playlist;
import com.sisyphusWeb.webService.model.table.Table;
import com.sisyphusWeb.webService.model.table.Track;
import com.sisyphusWeb.webService.payload.PauseResponse;
import com.sisyphusWeb.webService.payload.PlayResponse;
import com.sisyphusWeb.webService.payload.TimeResponse;
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
	
	public PlayResponse play() {
		
		String httpURL = baseURL + "/play";

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); 
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{}");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		restTemplate = new RestTemplate();
		
		return new Gson().fromJson(new JSONObject(restTemplate.postForObject(httpURL, request, String.class)).getJSONObject("resp").toString(), PlayResponse.class);
	}
	
	public PauseResponse pause() {
		String httpURL = baseURL + "/pause";

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); 
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{}");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		restTemplate = new RestTemplate();
		
		return new Gson().fromJson(new JSONObject(restTemplate.postForObject(httpURL, request, String.class)).getJSONObject("resp").toString(), PauseResponse.class);
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
	
	public  TimeResponse getTrackTime() {
		
		String httpURL = baseURL + "/get_track_time";
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{}");
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
		
		restTemplate = new RestTemplate();
		
		return new Gson().fromJson(new JSONObject(restTemplate.postForObject(httpURL, request, String.class)).getJSONObject("resp").toString(), TimeResponse.class);
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
	
	public BallPosition get_ball_position() {
		String httpURL = baseURL + "/get_ball_position";
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{}");
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
		
		restTemplate = new RestTemplate();
		
		return new Gson().fromJson(new JSONObject(restTemplate.postForObject(httpURL, request, String.class)).getJSONObject("resp").toString(), BallPosition.class);
	}
	
	public String start_streaming() {
		String httpURL = baseURL + "/start_streaming";

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); 
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{\"data\":{\"start_rho\":1,\"verts\":[{\"r\":1,\"th\":0}]}}");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		restTemplate = new RestTemplate();
		
		return new JSONObject(restTemplate.postForObject(httpURL, request, String.class)).getJSONArray("resp").getJSONObject(0).getString("streaming_id");
	}
	
	public void add_verts(String streamId, String coordinateString) {
		String httpURL = baseURL + "/add_verts_streaming";

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); 
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{\"data\":{\"id\":\"" + streamId + "\",\"verts\":["
				+ coordinateString + "]}}");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		restTemplate = new RestTemplate();
		
		new JSONObject(restTemplate.postForObject(httpURL, request, String.class));
	}
	
	public void clear_verts(String streamId, String coordinateString) {
		String httpURL = baseURL + "/clear_verts_streaming";

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); 
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{\"data\":{\"id\":\"" + streamId + "\",\"verts\":["
				+ coordinateString + "]}}");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		restTemplate = new RestTemplate();
		
		new JSONObject(restTemplate.postForObject(httpURL, request, String.class));
	}
	
	public void stop_streaming(String streamId) {
		String httpURL = baseURL + "/stop_streaming";

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); 
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{\"data\":{\"id\":\"" + streamId + "\"}}");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		restTemplate = new RestTemplate();
		
		new JSONObject(restTemplate.postForObject(httpURL, request, String.class));
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
	
	public Track set_track(String id) {
		Track track = trackRepo.findById(id).get();
		
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
	
	public boolean set_loop(boolean bool) {
		String httpURL = baseURL + "/set_loop";
		
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); 
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{\"data\":{\"value\":\"" + bool + "\"}}");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		restTemplate = new RestTemplate();
		
		Table table = new Gson().fromJson(new JSONObject(restTemplate.postForObject(httpURL, request, String.class)).getJSONArray("resp").getJSONObject(1).toString(), Table.class);
	
		return table.isIs_loop();
	}
	
	public boolean isLooping() {
		return getInfo().isIs_loop();
	}
}
