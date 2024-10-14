package com.workshop.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ContentController {

	@GetMapping("/home")
	public String handleWelcome() {
		System.out.println("Endpoint hit at /home");

		return "home";
	}

	@GetMapping("/admin/student/home")
	public String handleAdminHome() {
		System.out.println("Endpoint hit at /admin/home");
		return "home_admin";

	}

	@GetMapping("user/student/home")
	public String handleUserHome() {
		System.out.println("Endpoint hit at /student/home");
		return "home_user";

	}

}
