package com.trungndz.classroombook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungndz.classroombook.DAO.RoomsessionDAO;
import com.trungndz.classroombook.entities.Roomsession;


@Service
public class RoomsessionServiceImpl implements RoomsessionService{
	
	@Autowired
	private RoomsessionDAO roomsessionDAO;
	
	@Override
	public List<Object> getRoomsessionAvailable(){
		return roomsessionDAO.getRoomsessionAvailable();
	}
	
	@Override
	public Iterable<Roomsession> findAll(){
		return roomsessionDAO.findAll();
	}

}
