package com.home.practice.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.practice.entity.ClassRoom;
import com.home.practice.repository.ClassRoomRepository;

@Service
public class ClassRoomBo {

	@Autowired
	ClassRoomRepository classRoomRepository;
	public ClassRoom addClassRomm(ClassRoom classRoom) {
		classRoomRepository.save(classRoom);
		return classRoom;
	}
	public List<ClassRoom> getClassRooms() {
		return classRoomRepository.findAll();
	}
}