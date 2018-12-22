package com.trungndz.classroombook.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungndz.classroombook.DAO.PositionDAO;
import com.trungndz.classroombook.entities.Position;
import com.trungndz.classroombook.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService{
	
	@Autowired
	private PositionDAO positionDAO;
	
	@Override
	public Optional<Position> findById(int id) {
		return positionDAO.findById(id);
	}

}
