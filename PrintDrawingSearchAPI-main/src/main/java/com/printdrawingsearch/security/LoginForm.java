package com.printdrawingsearch.security;

/**
 * Represents a login form with username and password fields. This record
 * contains the data submitted in a login request.
 */
public record LoginForm(String username, String password) {

	/**
	 * Default constructor for provided username and password.
	 *
	 * @param username the username entered in the login form
	 * @param password the password entered in the login form
	 */
	public LoginForm {
		// No additional logic needed in this case
	}
}
