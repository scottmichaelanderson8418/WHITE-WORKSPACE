package com.workshop.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.workshop.app.dao.StudentRepository;
import com.workshop.app.model.Student;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private StudentRepository studentRepository;

	public MyUserDetailService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Student> student = studentRepository.findByUsername(username);

		if (student.isPresent()) {
			// this retrieves an instance of the Student Class
			Student studentObj = student.get();

			studentObj.setRole("ADMIN, USER");

			return User.builder().username(studentObj.getUsername()).password(studentObj.getPassword())
					.roles(getRoles(studentObj)).build();

		} else {
			throw new UsernameNotFoundException(username);
		}
	}

	private String[] getRoles(Student myStudent) {

		String temp1 = myStudent.getRole();

		temp1.split(",");

		// List<String> studentRolesList = new ArrayList<>();

		String[] studentRoles = temp1.split(",");

		// studentRolesList = Arrays.asList(studentRoles);

		return studentRoles;

	}

}
