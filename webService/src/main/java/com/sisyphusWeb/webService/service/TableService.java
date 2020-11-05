package com.sisyphusWeb.webService.service;

import org.json.JSONObject;
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
import com.sisyphusWeb.webService.model.table.Table;

@Service
public class TableService {
	private RestTemplate restTemplate;
	private final String baseURL = "http://173.20.96.222:3002/sisbot";
	
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
		
		Play play = new Gson().fromJson(new JSONObject(restTemplate.postForObject(httpURL, request, String.class)).getJSONObject("resp").toString(), Play.class);
		
		return play;
	}
	
	public Pause pause() {
		String httpURL = baseURL + "/pause";

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); 
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{}");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		restTemplate = new RestTemplate();
		
		Pause pause = new Gson().fromJson(new JSONObject(restTemplate.postForObject(httpURL, request, String.class)).getJSONObject("resp").toString(), Pause.class);

		return pause;
	}
	
	public Table connect() {
		String httpURL = baseURL + "/connect";
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{}");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		restTemplate = new RestTemplate();
		
		Table table = new Gson().fromJson(new JSONObject(restTemplate.postForObject(httpURL, request, String.class)).getJSONArray("resp").getJSONObject(0).toString(), Table.class);
		
		return table;
	}
}
