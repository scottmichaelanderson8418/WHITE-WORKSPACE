package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.MyUser;
import com.example.demo.repository.UserRepository;

@Controller
public class IndexController {

	@Autowired
	public UserRepository userRepository;

	/** The password encoder. */
	@Autowired
	private PasswordEncoder passwordEncoder; // Encoder for password hashing

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/")
	public String handleFormSubmission() {
		// Perform any necessary actions with the form data
		return "redirect:/";
	}

	@GetMapping("/login")
	public String handleLogin() {
		System.out.println("Endpoint hit at /login");
		return "custom_login";
	}

	@GetMapping("/register")
	public String createObjectForm(Model model) {

		model.addAttribute("user", new MyUser());

		return "register_form";
	}

	@PostMapping("/register")
	// @ModelAttribute - this will bind the annotated object with the model class
	public String userRegistration(@ModelAttribute MyUser myUser, Model model) {

		System.out.println("Username: " + myUser.getUsername());

		System.out.println("DOB: " + myUser.getDob());
		System.out.println("Email: " + myUser.getEmail());
		System.out.println("Password: " + myUser.getPassword());
		System.out.println("Role: " + myUser.getRole());

		model.addAttribute("username", myUser.getUsername());

		model.addAttribute("gender", myUser.getPassword());
		model.addAttribute("dob", myUser.getDob());
		model.addAttribute("email", myUser.getEmail());
		model.addAttribute("password", passwordEncoder.encode(myUser.getPassword()));
		model.addAttribute("role", myUser.getRole());

		MyUser user_inserted = userRepository.save(myUser);

		System.out.println("User = " + user_inserted.getUsername() + " is added to the database");

		List<MyUser> users = userRepository.findAll();

		model.addAttribute("users", users);

		return "welcome";
	}

	@GetMapping("/userList")
	public String createObject(@ModelAttribute MyUser user, Model model) {
		// Validate object data if necessary
		// Save object to database

		System.out.println("@GetMapping..................../userList");
		List<MyUser> users = userRepository.findAll();
		model.addAttribute("users", users);

		return "user_list";
	}
}
