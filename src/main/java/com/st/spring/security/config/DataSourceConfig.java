package com.st.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class DataSourceConfig {
	
	//private static final Logger LOG = Logger.getLogger(DataSourceConfig.class); not working
	
	@Bean
	@Profile("dev")
	public PropertySourcesPlaceholderConfigurer devEnvProperties() {
		System.out.println("Loading DEV jdbc properties");
		PropertySourcesPlaceholderConfigurer placeHolder = new PropertySourcesPlaceholderConfigurer();
		placeHolder.setLocation(new ClassPathResource("jdbc/jdbc-dev.properties"));
		return placeHolder;
	}
	
	@Bean
	@Profile("qa")
	public PropertySourcesPlaceholderConfigurer qaEnvProperties() {
		System.out.println("Loading QA jdbc properties");
		PropertySourcesPlaceholderConfigurer placeHolder = new PropertySourcesPlaceholderConfigurer();
		placeHolder.setLocation(new ClassPathResource("jdbc/jdbc-qa.properties"));
		return placeHolder;
	}
	
	@Bean
	@Profile("prod")
	public PropertySourcesPlaceholderConfigurer prodEnvProperties() {
		System.out.println("Loading PROD jdbc properties");
		PropertySourcesPlaceholderConfigurer placeHolder = new PropertySourcesPlaceholderConfigurer();
		placeHolder.setLocation(new ClassPathResource("jdbc/jdbc-prod.properties"));
		return placeHolder;
	}

}
