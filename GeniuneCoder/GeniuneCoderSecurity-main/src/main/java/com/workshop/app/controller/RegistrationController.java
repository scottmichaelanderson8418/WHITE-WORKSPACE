package com.workshop.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.app.dao.MyUserRepository;
import com.workshop.app.model.MyUser;

@RestController
public class RegistrationController {

	public static final Logger logger = LoggerFactory.getLogger(RegistrationController.class.getName());

	@Autowired
	private MyUserRepository myUserRepository;

	/*
	 * When the class has only one constructor argument, and the argument matches the field name -- then spring can
	 * automatically identify the dependency to be injected public RegistrationController(MyUserRepository
	 * myUserRepository) { this.myUserRepository = myUserRepository; }
	 */

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("/register/user")
	public ResponseEntity<?> registerNewUser(@RequestBody MyUser myUser) {
		logger.trace("Entered......AuthenticationAccessHandler() ");

		if (myUserRepository.findByUsername(myUser.getUsername()).isPresent()) {
			logger.trace("Exited......AuthenticationAccessHandler() ");

			return new ResponseEntity<String>("User already exist in database", HttpStatus.OK);

		}

		MyUser newUser = new MyUser();

		newUser.setPassword(passwordEncoder.encode(myUser.getPassword()));

		newUser.setUsername(myUser.getUsername());

		newUser.setRole(myUser.getRole());

		myUserRepository.save(newUser);
		logger.trace("Exited......AuthenticationAccessHandler() ");

		return new ResponseEntity<MyUser>(newUser, HttpStatus.OK);

	}

	// @PostMapping("/register/user")
	// public String registerNewUser(@ModelAttribute("myUser") MyUser myUser, Model model) {
	//
	// if (myUserRepository.findByUsername(myUser.getUsername()).isPresent()) {
	//
	// model.addAttribute("message", "The user already exists.");
	//
	// List<String> rolesUser = new ArrayList<>();
	//
	// rolesUser.add("ADMIN");
	// rolesUser.add("USER");
	// rolesUser.add("ADMIN, USER");
	//
	// model.addAttribute("roles", rolesUser);
	// model.addAttribute("myUser", new MyUser());
	//
	// return "register_user";
	//
	// }
	//
	// return "custom_login";
	//
	// }

	@GetMapping("/getAllUsers")
	public List<MyUser> getUsers(MyUserRepository myUserRepository) {

		List<MyUser> myUserList;

		myUserList = myUserRepository.findAll();

		// for (int i = 0; i < myUserList.size(); i++) {
		// System.out.println(myUserList.get(i).toString());
		// }

		return myUserList;

	}

	// // end point for posting user credentials to MySQl Database
	// @PostMapping("/register/user")
	// public MyUser registerUser(@RequestBody MyUser myUser) {
	//
	// // set the username
	// // myUser.setUsername(passwordEncoder.encode(myUser.getUsername()));
	//
	// myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
	//
	// return myUserRepository.save(myUser);
	//
	// }

}
