package com.home.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.practice.bo.StudentBo;
import com.home.practice.entity.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentBo studentBo;
	
	@Autowired
	ObjectMapper mapper;

	
	@GetMapping(value="/students", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getAllStudents(){
		return studentBo.getAllStudents();
	}
	
	@GetMapping(value="/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudent(@PathVariable("id") Integer id){
		return studentBo.getStudent(id);
	}
	
	@PostMapping(value="/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student saveStudent(@RequestBody Student student){
		return studentBo.saveStudent(student);
	}
	
	@PutMapping(value="/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student updateStudent(@RequestBody Student student) {
		return studentBo.updateStudent(student);
	}
	
	@DeleteMapping(value="/student/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteStudent(@PathVariable("studentId") Integer id) {
		return studentBo.deleteStudent(id);
	}
	
	@PatchMapping(value="/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateStudentPatch(@RequestBody Student student) {
		return studentBo.updateStudentPatch(student);
	}
	
	/******** APIs for advanced features ***********/

	@GetMapping(value = "/getStudentNativeQuery/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudentNativeQuery(@PathVariable("id") Integer id) {
		return studentBo.getStudentNativeQuery(id);
	}

	@GetMapping(value = "/getStudentJpql/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudentJpql(@PathVariable("id") Integer id) {
		return studentBo.getStudentJpql(id);
	}

	@GetMapping(value = "/studentCount", produces = MediaType.APPLICATION_JSON_VALUE)
	public String studentCount() {
		return studentBo.studentCount();
	}
}