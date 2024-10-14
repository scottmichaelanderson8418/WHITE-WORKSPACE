package com.workshop.app.auth;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationAccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	// Initialize a logger for the class
	Logger logger = LoggerFactory.getLogger(AuthenticationAccessHandler.class.getName());

	// when the login is a success then grant "ROLE_ADMIN" and land on the
	// /admin/home or /user/home page
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {

		logger.trace("Entered......AuthenticationAccessHandler() ");
		logger.debug("Entered......AuthenticationAccessHandler() ");

		// if the granted authority is equal to"ROLE_ADMIN"
		boolean isAdmin = authentication.getAuthorities().stream()
				.anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

		if (isAdmin) {
			System.out.println("User has authorization: ADMIN");
			setDefaultTargetUrl("/admin/home");

		} else {
			System.out.println("User has Authorization: USER");
			setDefaultTargetUrl("/user/home");
		}
		// setDefaultTargetUrl();
		super.onAuthenticationSuccess(request, response, authentication);
		logger.trace("Exited......AuthenticationAccessHandler() ");
		logger.debug("Exited......AuthenticationAccessHandler() ");
	}
}
