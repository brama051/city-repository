package com.brama.cityrepository.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.brama.cityrepository.service.AuthenticationService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	private static Logger logger = Logger.getAnonymousLogger();
	
	@Value("${security.jwt.client-id}")
	private String clientId;

	@Value("${security.jwt.client-secret}")
	private String clientSecret;
	
	@Override
	public Map<String, String> createAuthenticationRequest(String username, String password) {
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", "Basic " + this.encodeCredentials(username, password));		
		
		HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(null, headers);

		Map<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);
		map.put("grant_type", "password");

	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/oauth/token" + this.buildQueryParameters(map), request, String.class);
	    	    
		return this.stringToMap(response.getBody());
	}
	
	private String encodeCredentials(String username, String password) {
		String toEncode = clientId + ':' + clientSecret;
		return new String(Base64Utils.encode(toEncode.getBytes(StandardCharsets.ISO_8859_1)), StandardCharsets.ISO_8859_1);
	}
	
	private String buildQueryParameters(Map<String, String> map) {
		List<String> keyValue = new ArrayList<>();
		for (Entry<String, String> entry : map.entrySet()) {
			keyValue.add(entry.getKey() + "=" + entry.getValue());
		}
		
		return '?' + Strings.join(keyValue, '&');
	}
	
	private Map<String, String> stringToMap(String json) {
		Map<String,String> map = new HashMap<String,String>();
		ObjectMapper mapper = new ObjectMapper();

		try {
		    //convert JSON string to Map
		   map = mapper.readValue(json, new TypeReference<HashMap<String,String>>(){});
		} catch (Exception e) {
		     logger.info(e.getMessage());
		}

		return map;
	}
	
}
