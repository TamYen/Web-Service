package com.trungndz.classroombook.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungndz.classroombook.DAO.ShiftSessionDAO;
import com.trungndz.classroombook.entities.Shiftsession;
import com.trungndz.classroombook.service.ShiftSessionService;

@Service
public class ShiftSessionServiceImpl implements ShiftSessionService{

	@Autowired
	private ShiftSessionDAO sessionDAO;
	
	@Override
	public Optional<Shiftsession> findById(int id) {
		return sessionDAO.findById(id);
	}
}
