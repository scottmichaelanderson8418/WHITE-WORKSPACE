package com.workshop.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.app.model.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {

	Optional<MyUser> findByUsername(String username);

}
