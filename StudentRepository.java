package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	List<Student> getStudentByFirstName(String firstName);
	
}
