package com.trungndz.classroombook.service;

import java.util.Optional;

import com.trungndz.classroombook.entities.Shiftsession;

public interface ShiftSessionService {

	Optional<Shiftsession> findById(int id);

}
