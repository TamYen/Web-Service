package com.trungndz.classroombook.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.trungndz.classroombook.entities.Roomsession;

public interface RoomsessionService {

//	@Query("SELECT r.id, r.creator FROM Roomsession r")
//	List<Object> getRoomsessionAvailable();

	Iterable<Roomsession> findAll();

	List<Object> getRoomsessionAvailableForAdmin();
	
	List<Object> getRoomsessionAvailableForTeacher();

	List<Object> searchRoomsessionByDateAndByShiftSession(Date date, Integer idShift);

}
