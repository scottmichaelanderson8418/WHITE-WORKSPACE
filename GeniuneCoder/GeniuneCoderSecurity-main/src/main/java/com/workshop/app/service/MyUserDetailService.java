package com.workshop.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.workshop.app.dao.MyUserRepository;
import com.workshop.app.model.MyUser;

@Service
public class MyUserDetailService implements UserDetailsService {
	Logger logger = LoggerFactory.getLogger(MyUserDetailService.class.getName());

	@Autowired
	private MyUserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.trace("Entered......MyUserDetailService() ");
		logger.debug("Entered......MyUserDetailService() ");

		Optional<MyUser> user = repository.findByUsername(username);
		if (user.isPresent()) {
			var userObj = user.get();
			logger.trace("Exited......MyUserDetailService() ");
			logger.debug("Exited......MyUserDetailService() ");
			return User.builder().username(userObj.getUsername()).password(userObj.getPassword())
					.roles(getRoles(userObj)).build();
		} else {
			throw new UsernameNotFoundException(username);
		}
	}

	// private String[] getRoles(MyUser user) {
	// if (user.getRole() == null) {
	// return new String[] { "USER" };
	// }
	// return user.getRole().split(",");
	// }
	//

	private String[] getRoles(MyUser myUser) {

		String temp1 = myUser.getRole();

		temp1.split(",");

		List<String> userRolesList = new ArrayList<>();

		String[] userRoles = temp1.split(",");

		userRolesList = Arrays.asList(userRoles);

		return userRoles;

	}

}
