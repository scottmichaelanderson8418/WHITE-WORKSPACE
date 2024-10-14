package com.workshop.app.security;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.workshop.app.dao.MyUserRepository;
import com.workshop.app.model.MyUser;

@Component
public class MyUserDetailsService implements UserDetailsService {
	Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class.getName());

	@Autowired
	MyUserRepository myUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.trace("Entered......MyUserDetailsService() ");
		logger.debug("Entered......MyUserDetailsService() ");

		Optional<MyUser> myUser = myUserRepository.findByUsername(username);

		if (myUser.isPresent()) {
			// we will provide a userDetails for the user
			// We are creating a "User" instance with the MyUser "myUser" instance
			var userObj = myUser.get();
			logger.trace("Exited......MyUserDetailsService() ");
			logger.debug("Exited......MyUserDetailsService() ");
			return User.builder().username(userObj.getUsername()).password(userObj.getPassword())
					.roles(getRoles(userObj)).build();

		} else {
			throw new UsernameNotFoundException(username);
		}

	}

	//
	private String[] getRoles(MyUser myUser) {

		// if user role is empty just return "USER"
		if (myUser.getRole() == null) {

			return new String[] { "USER" };

		}
		// this will return a String[]
		return myUser.getRole().split(",");

	}

}
