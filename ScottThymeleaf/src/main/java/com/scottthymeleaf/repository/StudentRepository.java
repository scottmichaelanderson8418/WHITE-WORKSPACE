package com.scottthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scottthymeleaf.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
