package com.printdrawingsearchapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.printdrawingsearchapi.model.MyUser;

/**
 * Repository interface for {@link MyUser} entities. Provides methods to perform CRUD operations and custom query
 * methods.
 */

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

	/**
	 * Find user by username.
	 *
	 * @param username the username
	 * @return the optional
	 */
	Optional<MyUser> findByUsername(String username);

	/**
	 * Delete user by id.
	 *
	 * @param id the id
	 */

	void deleteById(Long id);
}
