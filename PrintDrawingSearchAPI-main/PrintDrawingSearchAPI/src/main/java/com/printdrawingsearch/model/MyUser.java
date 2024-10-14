package com.printdrawingsearch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The MyUser class represents a user entity in the system. It contains
 * information about the user's ID, username, password, and role.
 */
@Entity
@Table(name = "myusers")
public class MyUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String password;
	private String role; // Eg: ADMIN, USER
	private String username;

	/**
	 * Gets the user ID.
	 *
	 * @return the user ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the user ID.
	 *
	 * @param id the user ID to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the user's password.
	 *
	 * @return the user's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the user's password.
	 *
	 * @param password the user's password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the user's role.
	 *
	 * @return the user's role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the user's role.
	 *
	 * @param role the user's role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Gets the user's username.
	 *
	 * @return the user's username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the user's username.
	 *
	 * @param username the user's username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}
