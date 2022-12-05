package com.home.practice.bo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.practice.entity.Student;
import com.home.practice.repository.StudentRepository;

@Service
public class StudentBo {

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student getStudent(Integer id) {
		return studentRepository.findById(id).get();
	}

	@Transactional
	public Student saveStudent(Student student) {
		studentRepository.save(student);
		return student;
	}
	
	public Student updateStudent(Student student) {
		studentRepository.save(student);
		return student;
	}
	
	public String deleteStudent(Integer id) {
		studentRepository.deleteById(id);
		return "{\"status\": true, message: \"record deleted successfully\"}";
	}
	
	public String updateStudentPatch(Student student) {
		Student dbStudent = studentRepository.getReferenceById(student.getStudentId());
		
		if(student.getAddress() != null) {
			dbStudent.setAddress(student.getAddress());
		}
		
		if(student.getNotes() != null) {
			dbStudent.setNotes(student.getNotes());
		}
		
		if(student.getMobile() != null) {
			dbStudent.setMobile(student.getMobile());
		}
		
		if(student.getStdName() != null) {
			dbStudent.setStdName(student.getStdName());
		}
		
		studentRepository.save(dbStudent);
		return "{\"status\": true, message: \"record updated successfully\"}";
	}
}