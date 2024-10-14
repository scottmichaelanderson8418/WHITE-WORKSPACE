package com.workshop.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {
	Logger logger = LoggerFactory.getLogger(ContentController.class.getName());

	@GetMapping("/home")
	public String handleWelcome() {
		System.out.println("Endpoint hit at /home");

		return "home_page";
	}

	@GetMapping("/admin/home")
	public String handleAdminHome() {
		System.out.println("Endpoint hit at /admin/home");
		return "home_admin";
	}

	@GetMapping("/user/home")
	public String handleUserHome() {
		System.out.println("Endpoint hit at /user/home");
		return "home_user";
	}

	@GetMapping("/login")
	public String handleLogin() {
		System.out.println("Endpoint hit at /login");
		return "custom_login";
	}

	@GetMapping("/register/user")
	public String handleRegisterUser(Model model) {

		return "register_user";
	}

}
