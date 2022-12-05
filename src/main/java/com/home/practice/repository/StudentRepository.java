package com.home.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.practice.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}