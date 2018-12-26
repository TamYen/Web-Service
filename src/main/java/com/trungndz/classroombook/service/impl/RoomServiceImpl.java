package com.trungndz.classroombook.service.impl;

import java.sql.Date;
import java.util.List;
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
	
	@Override
	public List<Integer> getRoomNotActiveByDateandBySession(Date date, int session){
		return roomDAO.listRoom(date, session);
	}

	@Override
	public List<Object> getRoomActiveByDateandBySession(Date sqlDate, int session) {
		// TODO Auto-generated method stub
		return roomDAO.listRoomAvailable(sqlDate, session);
	}
}
