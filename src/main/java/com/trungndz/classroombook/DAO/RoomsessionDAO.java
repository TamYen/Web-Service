package com.trungndz.classroombook.DAO;

import java.sql.Date;
import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.trungndz.classroombook.entities.Roomsession;
import com.trungndz.classroombook.entities.RoomsessionId;

public interface RoomsessionDAO extends CrudRepository<Roomsession, RoomsessionId>{

	@Query("SELECT r.room.roomname, r.shiftsession.idsession, r.id.date, r.employeesByCreator.nameemp FROM Roomsession r")
	List<Object> getRoomsessionAvailableForAdmin();
	
	@Query("SELECT r.room.idroom, r.room.roomname, r.shiftsession.idsession, r.id.date "
			+ "FROM Roomsession r "
			+ "WHERE r.employeesBySubscriber IS NULL")
	List<Object> getRoomsessionAvailableForTeacher();
	
	@Query("SELECT r.room.idroom, r.room.roomname, r.shiftsession.idsession, r.id.date FROM Roomsession r "
			+ "WHERE r.id.date = :date  AND r.shiftsession.idsession = :shift")
	List<Object> searchRoomsessionByDateAndByShiftSession(@org.springframework.data.repository.query.Param("date") Date date, @org.springframework.data.repository.query.Param("shift") Integer idShift);
	
	
}
