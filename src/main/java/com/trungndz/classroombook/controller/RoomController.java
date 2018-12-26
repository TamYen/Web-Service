package com.trungndz.classroombook.controller;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trungndz.classroombook.handler.Handler;
import com.trungndz.classroombook.service.RoomService;

@RestController
@RequestMapping("Room")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@GetMapping("search")
	public ResponseEntity<List<Integer>> getRoomActive(@RequestParam("date") String date, @RequestParam("session") int session){
		Handler h = new Handler();
		Date sqlDate;
		try {
			sqlDate = h.parseStringToDateSql(date);
			List<Integer> list = roomService.getRoomNotActiveByDateandBySession(sqlDate, session);
			return new ResponseEntity<List<Integer>>(list, HttpStatus.OK);

		}catch(ParseException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("roomavailble")
	public ResponseEntity<List<Object>> getRoomNotActive(@RequestParam("date") String date, @RequestParam("session") int session){
		Handler h = new Handler();
		Date sqlDate;
		try {
			sqlDate = h.parseStringToDateSql(date);
			List<Object> list = roomService.getRoomActiveByDateandBySession(sqlDate, session);
			return new ResponseEntity<List<Object>>(list, HttpStatus.OK);

		}catch(ParseException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
