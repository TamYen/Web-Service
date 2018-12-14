package com.trungndz.classroombook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trungndz.classroombook.entities.Roomsession;
import com.trungndz.classroombook.service.RoomsessionService;

@RestController
@RequestMapping("Roomsession")
public class RoomsessionController {
	
	@Autowired
	private RoomsessionService roomsessionService;
	
	@GetMapping("available")
	public ResponseEntity<List<Roomsession>> getRoomsessionAvailable(){
		List<Roomsession> list =  (List<Roomsession>) roomsessionService.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("all")
	public ResponseEntity<List<Object>> getAll(){
		List<Object> list =  roomsessionService.getRoomsessionAvailable();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
