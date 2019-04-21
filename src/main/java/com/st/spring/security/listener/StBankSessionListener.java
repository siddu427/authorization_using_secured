package com.st.spring.security.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class StBankSessionListener implements HttpSessionListener {
	
	private final static Logger LOG = Logger.getLogger(StBankSessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		LOG.info("Session created, setting time out to 5mins");
		event.getSession().setMaxInactiveInterval(5*60);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		LOG.info("Session destroyed");
	}

}
