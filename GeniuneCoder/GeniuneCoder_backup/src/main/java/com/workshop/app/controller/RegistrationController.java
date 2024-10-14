package com.workshop.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.app.dao.MyUserRepository;
import com.workshop.app.model.MyUser;

@RestController
public class RegistrationController {

	@Autowired
	private MyUserRepository myUserRepository;

	/*
	 * When the class has only one constructor argument, and the argument matches
	 * the field name -- then spring can automatically identify the dependency to be
	 * injected public RegistrationController(MyUserRepository myUserRepository) {
	 * this.myUserRepository = myUserRepository; }
	 */

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("/register/user")
	public MyUser createUser(@RequestBody MyUser user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		return myUserRepository.save(user);
	}

	@GetMapping("/getAllUsers")
	public List<MyUser> getUsers(MyUserRepository myUserRepository) {

		List<MyUser> myUserList;

		myUserList = myUserRepository.findAll();

		return myUserList;

	}

}
