package com.st.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.st.spring.security.service.AuthorizationTestService;

@Controller
public class AuthorizationTestController {
	
	@Autowired
	private AuthorizationTestService authorizationTestService;
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/user/method", method = RequestMethod.GET)
	public String testUserMetod(Model model) {
		model.addAttribute("msg", "User Method Called");
		return "homePage";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/method", method = RequestMethod.GET)
	public String testAdminMetod(Model model) {
		model.addAttribute("msg", "Admin Method Called");
		return "homePage";
	}
	
	@RequestMapping(value = "/user/service/method", method = RequestMethod.GET)
	public String testUserServiceMetod(Model model) {
		model.addAttribute("msg", authorizationTestService.userMethod());
		return "homePage";
	}
	
	@RequestMapping(value = "/admin/service/method", method = RequestMethod.GET)
	public String testAdminServiceMetod(Model model) {
		model.addAttribute("msg", authorizationTestService.adminMethod());
		return "homePage";
	}
	
	

}
