package com.workshop.app.auth;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationAccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	// when the login is a success then grant "ROLE_ADMIN" and land on the
	// /admin/home or /user/home page
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {

		boolean isAdmin = authentication.getAuthorities().stream()
				.anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

		if (isAdmin) {
			setDefaultTargetUrl("/admin/home");

		} else {
			setDefaultTargetUrl("/user/home");
		}
		// setDefaultTargetUrl();
		super.onAuthenticationSuccess(request, response, authentication);

	}
}
