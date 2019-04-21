package com.st.spring.security.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@Import({DataSourceConfig.class})
@ComponentScan(basePackages={"com.st.spring.security.service", "com.st.spring.security.dao", "com.st.spring.security.auth"})
/*
 * the below annotation is there to detect the @Secured annotations 
 * used in the service classes
 */
@EnableGlobalMethodSecurity(securedEnabled = true)
public class RootConfig {
	
	//private static final Logger LOG = Logger.getLogger(RootConfig.class); not working
	
	@Value("${jdbc.datasource.driverClassName}")
	private String databaseDriverClassName;
	 
	@Value("${jdbc.datasource.url}")
	private String datasourceUrl;
	 
	@Value("${jdbc.datasource.username}")
	private String databaseUsername;
	 
	@Value("${jdbc.datasource.password}")
	private String databasePassword;
	
	@Value("${jdbc.datasource.connection}")
	private int maxConnections;
			
	@Bean
    public DataSource datasource() throws PropertyVetoException {
    	System.out.println("Starting to initialise DataSource " + datasourceUrl);
    	
    	ComboPooledDataSource dataSrc = new ComboPooledDataSource();
    	dataSrc.setDriverClass(databaseDriverClassName);
    	dataSrc.setJdbcUrl(datasourceUrl);
    	dataSrc.setUser(databaseUsername);
    	dataSrc.setPassword(databasePassword);
    	dataSrc.setMaxPoolSize(maxConnections);
    	
    	System.out.println("DataSource initialisation completed successfully");
    	return dataSrc;
    }
    
    @Bean 
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
    	System.out.println("JDBC Initialisation called");
    	return new NamedParameterJdbcTemplate(dataSource);
    }
	
	
}
