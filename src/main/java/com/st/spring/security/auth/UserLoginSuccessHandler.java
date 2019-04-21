package com.st.spring.security.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.st.spring.security.util.Constants;

@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger LOG = LoggerFactory.getLogger(UserLoginSuccessHandler.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
			HttpServletResponse response, 
			Authentication authentication) throws IOException, ServletException {
		
		if (authentication.isAuthenticated()) {
			LOG.info("Authentication successful redirecting to user home page");
			HttpSession session = request.getSession(false);
			if (session == null) {
				session = request.getSession(true);
			}
			String userName = authentication.getName();
			LOG.info("Storing {} user name to session", userName);
			session.setAttribute(Constants.USER_NAME, userName);
			
			response.sendRedirect(request.getContextPath() + "/homePage");
		} else {
			LOG.info("Authentication failed");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
