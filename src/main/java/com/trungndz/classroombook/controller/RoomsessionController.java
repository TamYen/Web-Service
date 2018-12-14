package com.trungndz.classroombook.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trungndz.classroombook.entities.Roomsession;
import com.trungndz.classroombook.service.RoomsessionService;

@RestController
@RequestMapping("Roomsession")
public class RoomsessionController {
	
	@Autowired
	private RoomsessionService roomsessionService;
	
//	@GetMapping("available")
//	public ResponseEntity<List<Roomsession>> getRoomsessionAvailable(){
//		List<Roomsession> list =  (List<Roomsession>) roomsessionService.findAll();
//		return new ResponseEntity<>(list, HttpStatus.OK);
//	}
	
	@GetMapping("available-ad")
	public ResponseEntity<List<Object>> getRoomsessionAvailableAdmin(){
		List<Object> list =  roomsessionService.getRoomsessionAvailableForAdmin();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("available-teacher")
	public ResponseEntity<List<Object>> getRoomsessionAvailableTearcher(){
		List<Object> list =  roomsessionService.getRoomsessionAvailableForTeacher();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("search/{date}/{shift}")
	public ResponseEntity<List<Object>> searchRoomAvailable(@PathVariable("date") String date, @PathVariable("shift") Integer shift){

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date dateUtil;
		try {
			dateUtil = sdf1.parse(date);
			
			java.sql.Date sqlStartDate = new java.sql.Date(dateUtil.getTime()); 
			
			List<Object> list = roomsessionService.searchRoomsessionByDateAndByShiftSession(sqlStartDate, shift);
			return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		

				
//		Date d = Date.valueOf(dateformat);
//		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}

}
