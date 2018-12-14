package com.trungndz.classroombook.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.trungndz.classroombook.entities.Roomsession;
import com.trungndz.classroombook.entities.RoomsessionId;

public interface RoomsessionDAO extends CrudRepository<Roomsession, RoomsessionId>{

	@Query("SELECT r.room.roomname, r.shiftsession.idsession, r.id.date, r.employeesByCreator.nameemp FROM Roomsession r")
	List<Object> getRoomsessionAvailable();
}
