package com.workshop.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.workshop.app.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findByUsername(String email);

	// this will create the necessary SQL query to find by email
	Optional<Student> findByEmail(String email);

	// List<Student> findAll();

	// @Query("SELECT * FROM myposts.student")
	// // the domain argument will be taken by the query and fill it
	// List<Student> findAllStudents();

	@Query("SELECT s from Student s WHERE s.email LIKE %:domain")
	// the domain argument will be taken by the query and fill it
	Optional<List<Student>> findByDomain(@Param("domain") String domain);

}
