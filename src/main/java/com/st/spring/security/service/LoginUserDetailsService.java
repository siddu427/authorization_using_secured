package com.st.spring.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.st.spring.security.dao.UserDao;
import com.st.spring.security.model.LoginUser;

@Component
public class LoginUserDetailsService implements UserDetailsService {

	private static final Logger LOG = LoggerFactory.getLogger(LoginUserDetailsService.class);
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		LOG.debug("Called with user name {}", userName);
		LoginUser user = userDao.getUserDetails(userName);
		return user;
	}
}
