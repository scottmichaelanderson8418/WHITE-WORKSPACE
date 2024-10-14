
package com.workshop.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.workshop.app.dao.MyUserRepository;
import com.workshop.app.model.MyUser;

@Controller
public class ContentController {

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MyUserRepository myUserRepository;

	@GetMapping("/")
	public String handleWelcome() {
		System.out.println("Endpoint hit at '/'");
		System.out.println("\nEntering home_page.html.html ------------");

		return "home_page";
	}

	@GetMapping("/admin/home")
	public String handleAdminHome() {
		System.out.println("Endpoint hit at /admin/home");
		System.out.println("\nEntering home_admin.html------------");
		return "home_admin";
	}

	@GetMapping("/user/home")
	public String handleUserHome() {
		System.out.println("Endpoint hit at /user/home");
		System.out.println("\nEntering home_user.html--------");
		return "home_user";
	}

	@GetMapping("/login")
	public String handleLogin() {
		System.out.println("Endpoint hit at /login");
		System.out.println("\nEntering custom_login.html---------");
		return "custom_login";
	}

	@GetMapping("/register")
	public String handleRegisterUser(Model model) {

		model.addAttribute("myUser", new MyUser());
		System.out.println("\nEntering register_user_form.html-------");

		return "register_user_form";
	}

	@PostMapping("/register")
	public String handleRegisterUser(@ModelAttribute MyUser myUser, Model model) {

		System.out.println("Username : " + myUser.getUsername());

		System.out.println("Password : " + myUser.getPassword());

		System.out.println("Role: " + myUser.getRole());

		model.addAttribute("Username", myUser.getUsername());

		model.addAttribute("Password", myUser.getPassword());

		model.addAttribute("Role", myUser.getRole());

		String password = passwordEncoder.encode(myUser.getPassword());

		myUser.setPassword(password);

		MyUser user_inserted = myUserRepository.save(myUser);

		System.out.println("User = " + user_inserted.getUsername() + " is added to the database");

		List<MyUser> users = myUserRepository.findAll();

		model.addAttribute("users", users);

		System.out.println("---------------------------------");

		System.out.println("Username : " + myUser.getUsername());

		System.out.println("Password : " + myUser.getPassword());

		System.out.println("Role: " + myUser.getRole());
		System.out.println("\nEntering home_page.html -------------");

		return "home_page";

	}

	@GetMapping("/admin/userList")
	public String createObject(@ModelAttribute MyUser user, Model model) {
		// Validate object data if necessary
		// Save object to database

		System.out.println("@GetMapping..................../userList");
		List<MyUser> users = myUserRepository.findAll();
		model.addAttribute("users", users);

		return "user_list";
	}
}
