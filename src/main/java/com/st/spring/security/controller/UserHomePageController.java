package com.st.spring.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.st.spring.security.util.Constants;

@Controller
public class UserHomePageController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserHomePageController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		LOG.debug("Login page requested");
		return "loginPage";
	}
	
	@RequestMapping(value = "/homePage", method = RequestMethod.GET)
	public String getHomePage(HttpServletRequest request, Model model) {
		LOG.debug("Home page requested");
		
		HttpSession httpSession = request.getSession(false);
		String userName = (String) httpSession.getAttribute(Constants.USER_NAME);
		
		model.addAttribute("userName", userName);
		
		return "homePage";
	}
	
	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	public String getLoginFailedPage(Model model) {
		model.addAttribute("loginFailed", "true");
		return "loginPage";
	}
	
	@RequestMapping(value = "/logoutSuccess", method = RequestMethod.GET)
	public String getLogoutSuccessPage(Model model) {
		model.addAttribute("logoutSuccess", "true");
		return "loginPage";
	}
	
	
	
	
	
	
	
	
	
	
}
