package com.trungndz.classroombook.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.trungndz.classroombook.entities.Room;

public interface RoomService {

	Optional<Room> findById(int id);

	List<Integer> getRoomNotActiveByDateandBySession(Date date, int session);

	List<Integer> getRoomActiveByDateandBySession(Date sqlDate, int session);

}
