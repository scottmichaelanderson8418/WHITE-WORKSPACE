package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.MyUser;
import com.example.demo.repository.UserRepository;

//This is a custom user detail service
@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<MyUser> myUser = userRepository.findByEmail(username);

		if (myUser.isPresent()) {

			MyUser userObj = myUser.get();

			return User.builder().username(userObj.getEmail()).password(userObj.getPassword()).roles(getRoles(userObj))
					.build();
		} else {
			// this exception is provided by spring security
			throw new UsernameNotFoundException(username);
		}
	}

	private String[] getRoles(MyUser myUser) {

		String temp1 = myUser.getRole();

		temp1.split(",");

		List<String> userRolesList = new ArrayList<>();

		String[] userRoles = temp1.split(",");

		String roleAdmin = "ADMIN";

		for (int i = 0; i < userRoles.length; i++) {

			if (userRoles[i].toUpperCase().equals("ADMIN")) {

				String[] temp = { "ADMIN", "USER" };

				userRoles = temp;
				break;
			}
		}

		userRolesList = Arrays.asList(userRoles);

		return userRoles;

	}

}
