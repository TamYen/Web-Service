package com.trungndz.classroombook.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.trungndz.classroombook.DAO.RoomsessionDAO;
import com.trungndz.classroombook.entities.Roomsession;


@Service
public class RoomsessionServiceImpl implements RoomsessionService{
	
	@Autowired
	private RoomsessionDAO roomsessionDAO;
	
	@Override
	public List<Object> getRoomsessionAvailableForAdmin(){
		return roomsessionDAO.getRoomsessionAvailableForAdmin();
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

}
