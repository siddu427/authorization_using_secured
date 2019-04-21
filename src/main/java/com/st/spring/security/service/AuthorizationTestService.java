package com.st.spring.security.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationTestService {
	
	@Secured("ROLE_USER")
	public String userMethod() {
		return "User Service Method Called";
	}
	
	@Secured("ROLE_ADMIN")
	public String adminMethod() {
		return "Admin Service Method Called";
	}
	
	
	
	
	
	
	
	
	

}
