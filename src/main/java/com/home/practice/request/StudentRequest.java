package com.home.practice.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.home.practice.entity.ClassRoom;

public class StudentRequest {
	private Integer studentId;
	private ClassRoom classRoom;
	private String address;
	private String notes;
	
	@NotBlank(message = "Student mobile should be provided")
	@Size(min = 10, max = 12, message = "Student mobile number should have minimum 10 digits and max 12 digits")
	@Pattern(regexp = "^[0-9]+$")
	private String mobile;
	
	@NotBlank(message = "Student name should be provided")
	private String stdName;
	
	public StudentRequest(Integer studentId, ClassRoom classRoom, String address, String notes, String mobile,
			String stdName) {
		super();
		this.studentId = studentId;
		this.classRoom = classRoom;
		this.address = address;
		this.notes = notes;
		this.mobile = mobile;
		this.stdName = stdName;
	}

	

	public StudentRequest() {
		super();
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public ClassRoom getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

}