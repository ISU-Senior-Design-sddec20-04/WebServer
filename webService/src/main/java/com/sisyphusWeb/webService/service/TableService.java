package com.sisyphusWeb.webService.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.sisyphusWeb.webService.model.table.Connect;
import com.sisyphusWeb.webService.model.table.Pause;
import com.sisyphusWeb.webService.model.table.Play;

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
		Play response = restTemplate.postForObject(httpURL, request, Play.class);
		
		return response;
	}
	
	public Pause pause() {
		String httpURL = baseURL + "/pause";

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); 
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{}");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		restTemplate = new RestTemplate();
		Pause response = restTemplate.postForObject(httpURL, request, Pause.class);
		
		return response;
	}
	
	public Connect connect() {
		String httpURL = baseURL + "/connect";
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("data", "{}");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		restTemplate = new RestTemplate();
		Connect response = restTemplate.postForObject(httpURL, request, Connect.class);
		
		return response;
	}
}
