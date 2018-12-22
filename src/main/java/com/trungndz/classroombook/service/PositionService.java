package com.trungndz.classroombook.service;

import java.util.Optional;

import com.trungndz.classroombook.entities.Position;

public interface PositionService{

	Optional<Position> findById(int id);

}
