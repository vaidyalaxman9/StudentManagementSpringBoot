package com.home.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.practice.bo.ClassRoomBo;
import com.home.practice.entity.ClassRoom;

@RestController
@RequestMapping("/classroom")
public class ClassRoomController {

	@Autowired
	ClassRoomBo classRoomBo;

	@PostMapping(value = "/classroom", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClassRoom addClassRoom(@RequestBody ClassRoom classRoom) {
		return classRoomBo.addClassRomm(classRoom);
	}

	@GetMapping(value = "/classroom", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClassRoom> getClassRooms() {
		return classRoomBo.getClassRooms();
	}
}