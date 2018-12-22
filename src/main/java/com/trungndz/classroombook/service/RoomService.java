package com.trungndz.classroombook.service;

import java.util.Optional;

import com.trungndz.classroombook.entities.Room;

public interface RoomService {

	Optional<Room> findById(int id);

}
