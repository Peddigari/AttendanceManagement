package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.entity.Student;
import com.repository.StudentRepository;
@SpringBootTest
class StudentServiceTest {
	@Autowired
	StudentService studentservice;
	@MockBean
	StudentRepository repo;
	@Test
	void testAddStudent() {
		Student s1=new Student();
		s1.setId(1);
		s1.setFirstName("peddigari");
		s1.setLastName("Shruthi");
		
	Mockito.when(repo.save(s1)).thenReturn(s1);
		
		assertThat(studentservice.addStudent(s1)).isEqualTo(s1);
	}	

	@Test
	void testGetStudents() {
			Student s1=new Student();
			s1.setId(1);
			s1.setFirstName("peddigari");
			s1.setLastName("Shruthi");
			
			Student s2=new Student();
			s2.setId(2);
			s2.setFirstName("peddigari");
			s2.setLastName("Shruthi");
						
			List<Student> studentList = new ArrayList<>();
			studentList.add(s1);
			studentList.add(s2);
			
			Mockito.when(repo.findAll()).thenReturn(studentList);
			
			assertThat(studentservice.getStudents()).isEqualTo(studentList);}
			

	@Test
	@Disabled
	void testGetStudentById() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDeleteStudentById() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteStudent() {
			Student s1=new Student();
			s1.setId(1);
			s1.setFirstName("peddigari");
			s1.setLastName("Shruthi");

			Optional<Student> s11=Optional.empty();
			
			Mockito.when(repo.findById(1)).thenReturn(s11);
			 Mockito.when(repo.existsById(s1.getId())).thenReturn(false);
			   assertFalse(repo.existsById(s1.getId()));}

		


	@Test
	void testUpdateStudent() throws Throwable {
		Student s1=new Student();
		s1.setId(1);
		s1.setFirstName("peddigari");
		s1.setLastName("Shruthi");
	Optional<Student> s2=Optional.of(s1);
	
	Mockito.when(repo.findById(1)).thenReturn(s2);
	
	Mockito.when(repo.save(s1)).thenReturn(s1);
	s1.setId(1);
	s1.setFirstName("peddigari");
	s1.setLastName("Shruthi");
	
	assertThat(studentservice.updateStudent(s1)).isEqualTo(s1);
}
}

/*	@Test
	void testAddStudents() {
		fail("Not yet implemented");
	}

	@Test
	void testGetStudentByFirstName() {
		fail("Not yet implemented");
	}

}*/
