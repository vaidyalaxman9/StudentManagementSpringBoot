package com.home.practice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "student")
public class Student implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer studentId;
	private ClassRoom classRoom;
	private String stdName;
	private String mobile;
	private String address;
	private String notes;

	public Student() {
	}
	
	public Student(String stdName, String mobile) {
		this.stdName = stdName;
		this.mobile = mobile;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "student_Id", unique = true, nullable = false)
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_class_Id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public ClassRoom getClassRoom() {
		return this.classRoom;
	}

	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}

	@Column(name = "std_Name", nullable = false, length = 10)
	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	@Column(name = "mobile", nullable = false, length = 12)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "address", length = 20)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "notes", length = 40)
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Student(ClassRoom classRoom,Integer studentId, String stdName, String mobile, String address, String notes) {
		super();
		this.classRoom = classRoom;
		this.studentId = studentId;
		this.stdName = stdName;
		this.mobile = mobile;
		this.address = address;
		this.notes = notes;
	}

}