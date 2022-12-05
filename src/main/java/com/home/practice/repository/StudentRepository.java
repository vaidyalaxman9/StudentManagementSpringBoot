package com.home.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.home.practice.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query(value = "SELECT * FROM Student where student_Id = :studId", nativeQuery = true)
	Student getStudentNativeQuery(@Param("studId") Integer id);

	@Query(value = "SELECT s FROM Student s where s.studentId = :studId")
	Student getStudentJpql(@Param("studId") Integer id);

	@Query(value = "select count(std_Name) from student", nativeQuery = true)
	Integer studentCount();
}