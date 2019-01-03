package com.trungndz.classroombook.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungndz.classroombook.DAO.RoomsessionDAO;
import com.trungndz.classroombook.entities.Roomsession;
import com.trungndz.classroombook.entities.RoomsessionId;
import com.trungndz.classroombook.service.RoomsessionService;


@Service
public class RoomsessionServiceImpl implements RoomsessionService{
	
	@Autowired
	private RoomsessionDAO roomsessionDAO;
	
	@Override
	public List<Object> getRoomsessionAvailableForAdmin(int idCreator){
		return roomsessionDAO.getRoomsessionAvailableForAdmin(idCreator);
	}
	
	@Override
	public List<Object> getRoomsessionAvailableForTeacher(){
		return roomsessionDAO.getRoomsessionAvailableForTeacher();
	}
	
	@Override
	public List<Object> searchRoomsessionByDateAndByShiftSession(Date date, Integer idShift){
		return roomsessionDAO.searchRoomsessionByDateAndByShiftSession(date, idShift);
	}
	
	@Override
	public Iterable<Roomsession> findAll(){
		return roomsessionDAO.findAll();
	}

	@Override
	public List<Object> viewHistory(Integer idEmp) {
		// TODO Auto-generated method stub
		return roomsessionDAO.viewHistory(idEmp);
	}

	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return roomsessionDAO.getAll();
	}
	
	@Override
	public void create(Roomsession roomsession) {
		roomsessionDAO.save(roomsession);
	}

	@Override
	public Optional<Roomsession> findById(RoomsessionId rid) {
		return roomsessionDAO.findById(rid);
	}

	@Override
	public void updateRoomSession(Roomsession rs) {
		roomsessionDAO.save(rs);		
	}
	
	@Override
	public List<Object> getRoomSessionNonApproved(){
		return roomsessionDAO.getRoomsessionNonApproved();
	}
	
	@Override
	public List<Object> getRoomsessionApproved(int idApprover){
		return roomsessionDAO.getRoomsessionApproved(idApprover);
	}
	
	@Override
	public void deleteSubscribed(Roomsession rs) {
		roomsessionDAO.delete(rs);
	}
}
