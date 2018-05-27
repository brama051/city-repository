package com.brama.cityrepository.service;

import java.util.Map;

public interface AuthenticationService {
	Map<String, String> createAuthenticationRequest(String username, String password);
}
