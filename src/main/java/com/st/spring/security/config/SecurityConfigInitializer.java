package com.st.spring.security.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityConfigInitializer extends AbstractSecurityWebApplicationInitializer {

	/**
	 * even though there is nothing done here, 
	 * this is very essential to recognize the configurations in
	 * SecurityConfig.java.
	 * But the SecurityConfig.java itself is loaded into root application context
	 * from ApplicationInitializer.java
	 */
}
