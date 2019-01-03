package com.trungndz.classroombook.DAO;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.trungndz.classroombook.entities.Roomsession;
import com.trungndz.classroombook.entities.RoomsessionId;

public interface RoomsessionDAO extends CrudRepository<Roomsession, RoomsessionId>{

	@Query("SELECT r.room, r.shiftsession, r.id.date, r.creator, r.subscriber, r.approver FROM Roomsession r")
	List<Object> getRoomsessionAvailableForAdmin();
	
	@Query("SELECT r.room.idroom, r.room.roomname, r.shiftsession.idsession, r.id.date, r.subscriber.idemp, r.subscriber.nameemp "
			+ "FROM Roomsession r "
			+ "WHERE r.approver IS NULL AND r.creator IS not NULL "
	      		+ "ORDER By r.id.date")
	List<Object> getRoomsessionNonApproved();
	
//	@Query("SELECT r.id.date, r.id.idsession, r.id.idroom, r.room.roomname, r.room.seatamount  "
//			+ "FROM Roomsession r "
//			+ "WHERE r.subscriber IS NULL")
//	@Query("SELECT r.room.idroom, r.room.roomname, r.shiftsession.idsession, r.id.date "
//	+ "FROM Roomsession r "
//	+ "WHERE r.subscriber IS NULL")
//	@Query("SELECT r.id, r.room, r.shiftsession FROM Roomsession r where r.subscriber IS NULL and r.approver IS NULL")
	@Query("SELECT r.room.idroom, r.room.roomname, r.shiftsession.idsession, r.id.date FROM Roomsession r where r.subscriber IS NULL and r.approver IS NULL")
	List<Object> getRoomsessionAvailableForTeacher(); // room no subscriber
	
	@Query("SELECT r.room.idroom, r.room.roomname, r.shiftsession.idsession, r.id.date FROM Roomsession r "
			+ "WHERE r.id.date = :date  AND r.shiftsession.idsession = :shift AND r.subscriber IS NULL AND r.approver IS NULL")
	List<Object> searchRoomsessionByDateAndByShiftSession(@org.springframework.data.repository.query.Param("date") Date date,
														  @org.springframework.data.repository.query.Param("shift") Integer idShift);

//	@Query("SELECT r.room.idroom, r.room.roomname, r.shiftsession.idsession, r.id.date FROM Roomsession r ")
//	@Query("SELECT r.room.roomname, r.shiftsession.idsession, r.id.date, r.employeesByCreator.nameemp FROM Roomsession r")
//	List<Object> viewHistory(Integer idEmp);

	@Query("SELECT r.room.idroom, r.room.roomname, r.shiftsession.idsession, r.id.date, r.subscriber.nameemp"
			+ " FROM Roomsession r WHERE r.subscriber.idemp = :idEmp ORDER BY r.id.date DESC")
	List<Object> viewHistory(@org.springframework.data.repository.query.Param("idEmp") Integer idEmp);

	
	@Query("SELECT r.room, r.shiftsession, r.id.date, "
			+ "r.creator, r.subscriber, r.approver FROM Roomsession r")
	List<Object> getAll();

	
	
	
	
}
//
//@Query("SELECT r.room.roomname, r.shiftsession.idsession, r.id.date, r.employeesByCreator.nameemp FROM Roomsession r")
//List<Object> getRoomsessionAvailableForAdmin();
//
//@Query("SELECT r.room.idroom, r.room.roomname, r.shiftsession.idsession, r.id.date "
//		+ "FROM Roomsession r "
//		+ "WHERE r.employeesBySubscriber IS NULL")
//List<Object> getRoomsessionAvailableForTeacher();
//
//@Query("SELECT r.room.idroom, r.room.roomname, r.shiftsession.idsession, r.id.date FROM Roomsession r "
//		+ "WHERE r.id.date = :date  AND r.shiftsession.idsession = :shift")
//List<Object> searchRoomsessionByDateAndByShiftSession(@org.springframework.data.repository.query.Param("date") Date date,
//													  @org.springframework.data.repository.query.Param("shift") Integer idShift);
//
////@Query("SELECT r.room.idroom, r.room.roomname, r.shiftsession.idsession, r.id.date FROM Roomsession r ")
////@Query("SELECT r.room.roomname, r.shiftsession.idsession, r.id.date, r.employeesByCreator.nameemp FROM Roomsession r")
////List<Object> viewHistory(Integer idEmp);
//
//@Query("SELECT r.room.idroom, r.room.roomname, r.shiftsession.idsession, r.id.date, r.employeesBySubscriber.nameemp"
//		+ " FROM Roomsession r WHERE r.employeesBySubscriber.idemp = :idEmp")
//List<Object> viewHistory(@org.springframework.data.repository.query.Param("idEmp") Integer idEmp);
//
//
//@Query("SELECT r.room.idroom, r.room.roomname, r.shiftsession.idsession, r.id.date, "
//		+ "r.employeesByCreator.idemp, r.employeesBySubscriber.idemp, r.employeesByApprover.idemp FROM Roomsession r")
//List<Object> getAll();

