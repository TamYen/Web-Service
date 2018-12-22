package com.trungndz.classroombook.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungndz.classroombook.DAO.RoomDAO;
import com.trungndz.classroombook.entities.Room;
import com.trungndz.classroombook.service.RoomService;


@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomDAO roomDAO;
	
	@Override
	public Optional<Room> findById(int id) {
		return roomDAO.findById(id);
	}
}
