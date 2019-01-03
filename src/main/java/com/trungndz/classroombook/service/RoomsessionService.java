package com.trungndz.classroombook.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.trungndz.classroombook.entities.Roomsession;
import com.trungndz.classroombook.entities.RoomsessionId;

public interface RoomsessionService {

//	@Query("SELECT r.id, r.creator FROM Roomsession r")
//	List<Object> getRoomsessionAvailable();

	Iterable<Roomsession> findAll();

	List<Object> getRoomsessionAvailableForAdmin(int idCreator);
	
	List<Object> getRoomsessionAvailableForTeacher();

	List<Object> searchRoomsessionByDateAndByShiftSession(Date date, Integer idShift);

	List<Object> viewHistory(Integer idEmp);

	List<Object> getAll();

	void create(Roomsession roomsession);

	Optional<Roomsession> findById(RoomsessionId rid);

	void updateRoomSession(Roomsession rs);

	List<Object> getRoomSessionNonApproved();

	void deleteSubscribed(Roomsession rs);

	List<Object> getRoomsessionApproved(int idApprover);

	void deleteRoomsession(Roomsession rs);

}
