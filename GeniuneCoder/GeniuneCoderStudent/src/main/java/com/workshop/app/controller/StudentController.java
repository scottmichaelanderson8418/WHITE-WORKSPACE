package com.workshop.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.app.dao.StudentRepository;
import com.workshop.app.exceptions.UserNotFoundException;
import com.workshop.app.model.Student;

@RestController
public class StudentController {

	private final StudentRepository studentRepository;

	/*
	 * When the class has only one constructor argument, and the argument matches the field name -- then spring can
	 * automatically identify the dependency to be injected public RegistrationController(MyUserRepository
	 * myUserRepository) { this.myUserRepository = myUserRepository; }
	 */

	@Autowired
	PasswordEncoder passwordEncoder;

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	// end point for posting user credentials to MySQl Database
	@PostMapping("/student/save")
	public ResponseEntity<String> createStudent(@RequestBody Student myStudent) {

		// Student studentObj = studentRepository.findByEmail(myStudent.getEmail())
		// .orElseThrow(() -> new UserNotFoundException(
		// "Print drawing could not be deleted"));

		Optional<Student> obj = studentRepository.findByEmail(myStudent.getEmail());

		if (obj.isPresent()) {
			return new ResponseEntity<>("User already registered with that email", HttpStatus.OK);

		}

		myStudent.setUsername(myStudent.getEmail());

		myStudent.setPassword(passwordEncoder.encode(myStudent.getPassword()));

		studentRepository.save(myStudent);

		return new ResponseEntity<>("New Student Created with email: " + myStudent.getEmail(), HttpStatus.OK);

	}

	// end point for login
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Student myStudent) {

		Optional<Student> student = studentRepository.findByEmail(myStudent.getEmail());

		if (student.isPresent()) {

			Student studentObj = student.get();

			if (myStudent.getPassword().equals(studentObj.getPassword())) {
				return new ResponseEntity<String>("User signed success!!", HttpStatus.OK);
			}

			return new ResponseEntity<String>("Wrong Password!!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("No user found", HttpStatus.BAD_REQUEST);
	}

	@PatchMapping("/student/update")
	public Student findStudent(@RequestParam("id") Long id, @RequestParam("new_email") String email) {

		Optional<Student> student = studentRepository.findById(id);

		if (student.isPresent()) {

			Student studentObj = student.get();

			studentObj.setEmail(email);

			studentObj.setUsername(studentObj.getEmail());

			return studentRepository.save(studentObj);
		}

		return null;
	}

	@GetMapping("/student/findByEmailDomain")
	public Optional<List<Student>> findStudentByDomain(@RequestParam("domain") String domain) {

		// check to see if email domains exists in the student table
		List<Student> studentObj = studentRepository.findByDomain(domain)
				.orElseThrow(() -> new UserNotFoundException("Students with domain could not be found"));

		// Create a list of students from the database with matching email domains
		Optional<List<Student>> studentDomains = studentRepository.findByDomain(domain);

		if (studentDomains.isPresent()) {
			System.out.println("Email domain = " + domain + " is present in the database");

			return studentDomains;

		}

		return null;

	}

	@GetMapping("/student/findByEmail")
	public Student findStudent(@RequestParam("email") String email) {

		Optional<Student> student = studentRepository.findByEmail(email);

		if (student.isPresent()) {

			System.out.println("FOUND THE STUDENT BY EMAIL!!!!!!!!!!!!!!!");
			Student studentObj = student.get();

			return studentObj;
		}

		return null;
	}
	// hi
	// @GetMapping("/student/findAllStudents")
	// public List<Student> findAllStudentsInRepository() {
	//
	// return studentRepository.findAllStudents();
	// }

	@GetMapping("/student/findAll")
	public List<Student> findAllInRepository() {

		return studentRepository.findAll();
	}

}
