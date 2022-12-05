package com.home.practice.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ClassRoom")
public class ClassRoom implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer classId;
	private String className;
	private String notes;
	
	@JsonIgnore
	private Set<Student> students = new HashSet<Student>(0);
	
	public ClassRoom() {
	}
	
	public ClassRoom(String className) {
		this.className = className;
	}

	public ClassRoom( String className, String notes,Set<Student> students) {
		super();
		this.className = className;
		this.notes = notes;
		this.students = students;
		
	}

	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "class_Id", unique = true, nullable = false)
	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	@Column(name = "class_Name", nullable = false, length = 10)
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name = "notes", length = 40)
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classRoom")
	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}