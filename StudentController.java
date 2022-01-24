package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Student;
import com.service.StudentService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class StudentController {

	@Autowired
	StudentService studentservice;
	
	
	@GetMapping(path="/getStudents")
	public ResponseEntity<List<Student>> getStudents()
	{
		List<Student> s1=studentservice.getStudents();
		ResponseEntity<List<Student>> re=new ResponseEntity<List<Student>>(s1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getStudentById/{sid}")
	public ResponseEntity<Student> getStudentById(@PathVariable int sid) throws Throwable
	{
        Student s1=studentservice.getStudentById(sid);
		
		ResponseEntity<Student> re=new ResponseEntity<Student>(s1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addStudents")
	public ResponseEntity<List<Student>> addStudents(@RequestBody List<Student> ls)
	{List<Student> le=studentservice.addStudents(ls);
		ResponseEntity<List<Student>> re=new ResponseEntity<List<Student>>(le,HttpStatus.OK);
		return re;
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student s)
	{
		Student s1=studentservice.addStudent(s);
		ResponseEntity<Student> re=new ResponseEntity<Student>(s1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateStudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student s) throws Throwable
	{
		Student s1=studentservice.updateStudent(s);
	    ResponseEntity<Student> re = new ResponseEntity<Student>(s1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteStudent")
	public ResponseEntity<String> deleteStudent(@RequestBody Student s)
	{
		studentservice.deleteStudent(s);
		ResponseEntity<String> re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteStudent/{sid}")
	public ResponseEntity<String> deleteStudentById(@PathVariable int sid)
	{
		studentservice.deleteStudentById(sid);
		ResponseEntity re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	
	
	
	
	
	@GetMapping(path="/getStudentByFirstName/{firstName}")
	public List<Student> getStudentByFirstName(@PathVariable String firstName)
	{
		List<Student> s1= studentservice.getStudentByFirstName(firstName);
		return s1;
	}
	
	
}
