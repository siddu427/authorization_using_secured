package com.st.spring.security.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUser implements UserDetails {

	private static final long serialVersionUID = 7128284196970277696L;
	
	private String userName;
	private String password;
	private List<String> roles;
	
	public LoginUser(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> 
	getAuthorities() {
		List<StGrantedAuthority> userRoles = new ArrayList<>();
		for (String role : roles) {
			userRoles.add(new StGrantedAuthority(role));
		}
		System.out.println("**** get auth called in login user ****");
		return userRoles;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
