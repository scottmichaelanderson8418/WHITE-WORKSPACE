package com.workshop.app.service;

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

import com.workshop.app.dao.MyUserRepository;
import com.workshop.app.model.MyUser;

//This is a custom user detail service
@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private MyUserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<MyUser> user = repository.findByUsername(username);

		if (user.isPresent()) {

			MyUser userObj = user.get();

			return User.builder().username(userObj.getUsername()).password(userObj.getPassword())
					.roles(getRoles(userObj)).build();
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
