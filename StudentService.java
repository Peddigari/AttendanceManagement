package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.StudentNotFoundException;
import com.entity.Student;
import com.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repo;

	public List<Student> getStudents() {
		List<Student> ls = repo.findAll();
		return ls;
	}
	
	public Student getStudentById(int id) throws Throwable {
		Supplier s1= ()->new StudentNotFoundException("Student Does not exist in the database");
		Student s=repo.findById(id).orElseThrow(s1);
		return s;
	}
	public String deleteStudentById(int sid) {
		
		repo.deleteById(sid);
		
		return " Record Deleted";
	}

	public String deleteStudent(Student s) {
		
		repo.delete(s);
		return "Deleted";
	}

	public Student updateStudent(Student s) throws Throwable {
		int id= s.getId();
		Supplier s2= ()->new StudentNotFoundException("Student Does not exist in the database");
		Student s1=repo.findById(id).orElseThrow(s2);
			repo.save(s);
			return s;	
	}

	public List<Student> addStudents(List<Student> ls) {
		repo.saveAll(ls);
		return ls;
	}
	
	
	public List<Student> getStudentByFirstName(String firstName) {
		List<Student> c = repo.getStudentByFirstName(firstName);
		return c;
	}

	public Student addStudent(Student s) {
		repo.save(s);
		return s;
	}


	

}

