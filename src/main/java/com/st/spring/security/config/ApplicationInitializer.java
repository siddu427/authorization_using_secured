package com.st.spring.security.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.util.Log4jConfigListener;

import com.st.spring.security.listener.StBankSessionListener;

@Configuration
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class, SecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {DispatcherConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	public void onStartup(ServletContext context) throws ServletException {
		super.onStartup(context);
		context.addListener(new StBankSessionListener());
		
		context.setInitParameter("log4jConfigLocation", "classpath:st-log4j.properties");
		context.addListener(new Log4jConfigListener());
	}

}
