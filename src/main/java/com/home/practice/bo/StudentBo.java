package com.home.practice.bo;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.practice.entity.Student;
import com.home.practice.exception.StudentManagementNotFoundException;
import com.home.practice.repository.StudentRepository;
@Service
public class StudentBo {
	
	private Logger logger = LoggerFactory.getLogger(StudentBo.class);	

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student getStudent(Integer id) throws StudentManagementNotFoundException {

	//public Student getStudent(Integer id) {
		//Student student = new Student();
		//try {
		//	student = studentRepository.findById(id).get();
		//} catch (Exception e) {
		//	logger.error("Error in getStudent for " + id + " , description: " + e.getMessage());
		//}
	//	return student;
	//}
	
	Optional<Student> studentOptional = studentRepository.findById(id);

	if (studentOptional.isPresent()) {
		return studentOptional.get();
	} else {
		throw new StudentManagementNotFoundException("Student doesn't exists with id " + id);
	}
}


	public Student saveStudent(Student  student) {
				try {
			student= studentRepository.save(student);
		} catch (Exception e) {
			logger.error("Error in saveStudent for " + student + " , description: " + e.getMessage());
		}
		
		return student;
	}
	
	public Student updateStudent(Student student) {
		try {
		  studentRepository.save(student);
		} catch (Exception e) {
			logger.error("Error in updateStudent for " + student + " , description: " + e.getMessage());
		}
		return student;
	}
	
	public String deleteStudent(Integer id) {
		try {
		studentRepository.deleteById(id);
		} catch (Exception e) {
			logger.error("Error in deleteStudent for " + id + " , description: " + e.getMessage());
			return "{\"status\": true, message: \"this student id is not available\"}";
		}
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
	
	public Student getStudentNativeQuery(Integer id) {
		return studentRepository.getStudentNativeQuery(id);
	}

	public Student getStudentJpql(Integer id) {
		return studentRepository.getStudentJpql(id);
	}

	public String studentCount() {
		Integer count = studentRepository.studentCount();
		return "{\"studentCount\": "+count+"}";
	}
}