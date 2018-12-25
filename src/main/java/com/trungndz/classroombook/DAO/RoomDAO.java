package com.trungndz.classroombook.DAO;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.trungndz.classroombook.entities.Room;

public interface RoomDAO extends CrudRepository<Room, Integer>{

	@Query("select r.id.idroom from Roomsession r where r.id.date = :date and r.id.idsession = :session")
	List<Integer> listRoom(@Param("date") Date date, @Param("session")int session);
	
	@Query("SELECT r.idroom FROM Room r WHERE r.idroom Not in"
			+ "(select rs.id.idroom from Roomsession rs where rs.id.date = :date and rs.id.idsession = :session)")
	List<Integer> listRoomAvailable(@Param("date") Date date, @Param("session")int session);
}
