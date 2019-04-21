package com.st.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.st.spring.security.controller")
/*
 * for @Secured to work u need to keep it in the config file where the component scan for the
 * required classes happen. For example, here @Secured is used in controller and controllers
 * component scan is done in this config, so this annotation has to be kept here.
 * If the @Secured is used in service layer then @EnableGlobalMethodSecurity has to be kept in
 * RootConfig class
 */
@EnableGlobalMethodSecurity(securedEnabled = true)
public class DispatcherConfig extends WebMvcConfigurerAdapter {

	/**
	 * this is similar to <mvc:resources>
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/*").addResourceLocations("/img/");
		registry.addResourceHandler("/style/*").addResourceLocations("/style/");
	}
	
	/**
	 * similar to <mvc:default-servlet-handler>
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
    public InternalResourceViewResolver getViewResolver(){
       InternalResourceViewResolver resolver = new InternalResourceViewResolver();
       resolver.setPrefix("/WEB-INF/view/");
       resolver.setSuffix(".jsp" );
       return resolver;
   }
}
