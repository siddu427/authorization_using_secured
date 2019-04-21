package com.st.spring.security.model;

import org.springframework.security.core.GrantedAuthority;

public class StGrantedAuthority implements GrantedAuthority {
	
	private static final long serialVersionUID = -8153416393275345176L;
	
	private String role;
	
	public StGrantedAuthority(String role) {
		this.role = role;
	}

	@Override
	public String getAuthority() {
		System.out.println("**** get auth called in granted authority ****");
		return role;
	}

}
