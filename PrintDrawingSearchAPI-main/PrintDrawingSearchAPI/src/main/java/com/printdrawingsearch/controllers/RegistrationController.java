package com.printdrawingsearch.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.printdrawingsearch.model.MyUser;
import com.printdrawingsearch.repository.MyUserRepository;

/**
 * Controller for user registration.
 */
@RestController
public class RegistrationController {
	Logger logger = LoggerFactory.getLogger(RegistrationController.class.getName());

	/** The my user repository. */
	@Autowired
	private MyUserRepository myUserRepository; // Repository for managing user data

	/** The password encoder. */
	@Autowired
	private PasswordEncoder passwordEncoder; // Encoder for password hashing

	/**
	 * Endpoint for user registration.
	 *
	 * @param user the user details
	 * @return a response indicating the result of the registration
	 */
	@PostMapping("/register/user")
	public ResponseEntity<String> createUser(@RequestBody MyUser user) {

		logger.trace("Entered......createUser() ");

		// Check if the username already exists
		if (myUserRepository.findByUsername(user.getUsername()).isPresent()) {

			logger.trace("Exited......createUser() ");
			// Return conflict response if username already exists
			return new ResponseEntity<>("User already exists. Try another username.", HttpStatus.CONFLICT);
		}

		// Encode user password before saving
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		// Save user details to the repository
		myUserRepository.save(user);

		logger.trace("Exited......createUser() ");
		// Return success response upon successful registration
		return new ResponseEntity<>("Registration is successful :)", HttpStatus.OK);
	}
}
