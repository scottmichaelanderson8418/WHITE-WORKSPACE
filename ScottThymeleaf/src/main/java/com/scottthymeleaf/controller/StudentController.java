package com.scottthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.scottthymeleaf.model.Student;
import com.scottthymeleaf.repository.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/create-student")
	public String createObjectForm(Model model) {
		System.out.println("@GetMapping.....................");
		model.addAttribute("student", new Student());

		return "student_form";
	}

	@PostMapping("/create-student")
	public String createObject(@ModelAttribute Student student, Model model) {
		// Validate object data if necessary
		// Save object to database

		System.out.println("@PostMapping.....................");

		studentRepository.save(student);

		List<Student> students = studentRepository.findAll();

		model.addAttribute("students", students);

		return "student_list";
	}

}
