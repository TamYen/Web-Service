package com.trungndz.classroombook.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trungndz.classroombook.entities.Employee;
import com.trungndz.classroombook.entities.Position;
import com.trungndz.classroombook.entities.Room;
import com.trungndz.classroombook.entities.RoomAvailable;
import com.trungndz.classroombook.entities.Roomsession;
import com.trungndz.classroombook.entities.RoomsessionId;
import com.trungndz.classroombook.entities.Shiftsession;
import com.trungndz.classroombook.handler.Handler;
import com.trungndz.classroombook.service.EmployeeService;
import com.trungndz.classroombook.service.RoomService;
import com.trungndz.classroombook.service.RoomsessionService;
import com.trungndz.classroombook.service.ShiftSessionService;

//@RestController
@Controller
@RequestMapping("Roomsession")
public class RoomsessionController {
	
	@Autowired
	private RoomsessionService roomsessionService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ShiftSessionService shiftSessionService;
	
	Handler handle = new Handler();
	
	@GetMapping("available")
	public ResponseEntity<List<Roomsession>> getRoomsessionAvailable(){
		List<Roomsession> list =  (List<Roomsession>) roomsessionService.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("available-ad")
	public ResponseEntity<List<Object>> getRoomsessionAvailableAdmin(@RequestParam("idCreator") int idCreator){
		List<Object> list =  roomsessionService.getRoomsessionAvailableForAdmin(idCreator);
		return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
	}
	
	@GetMapping("available-teacher")
	public ResponseEntity<List<Object>> getRoomsessionAvailableTearcher(){
		List<Object> list =  roomsessionService.getRoomsessionAvailableForTeacher();
		List<RoomAvailable> listRoom = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			RoomAvailable ra = new RoomAvailable();
			System.out.println(list.get(i));
//			ra.setIdroom(a);
//			ra.setRoomname(list.get(i).getRoom().getRoomname());
//			ra.setSession(list.get(i).getId().getIdsession());
//			ra.setDate(list.get(i).getId().getDate());
//			listRoom.add(ra);
		}
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("search/{date}/{shift}")
	public ResponseEntity<List<Object>> searchRoomAvailable(@PathVariable("date") String date, @PathVariable("shift") Integer shift){

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date dateUtil;
		try {
			dateUtil = sdf1.parse(date);
			
			java.sql.Date sqlDate = new java.sql.Date(dateUtil.getTime()); 
			
			List<Object> list = roomsessionService.searchRoomsessionByDateAndByShiftSession(sqlDate, shift);
			return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}	
//		Date d = Date.valueOf(dateformat);
//		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);		
	}
	
	@GetMapping("history/{user}")
	public ResponseEntity<List<Object>> ViewHistory(@PathVariable("user") Integer idEmp){
		List<Object> list = roomsessionService.viewHistory(idEmp);
		if(list.isEmpty() || list == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
	}
	
	@GetMapping("nonapproved")
	public ResponseEntity<List<Object>> getRoomSessionNonApproved(){
		List<Object> list = roomsessionService.getRoomSessionNonApproved();
		if(list.isEmpty() || list == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
	}
	
	@GetMapping("approved")
	public ResponseEntity<List<Object>> getRoomSessionApproved(@RequestParam("idApprover") int idApprover){
		List<Object> list = roomsessionService.getRoomsessionApproved(idApprover);
		if(list.isEmpty() || list == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
	}
	
	@GetMapping("all")
	public ResponseEntity<List<Object>> getAll(){
		List<Object> list = roomsessionService.getAll();
		return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
	}
	
	@PostMapping("testcreate")
	public ResponseEntity<Roomsession> testcreate(@RequestParam("room") int room, @RequestParam("session") int session,
										@RequestParam("date") String date, @RequestParam("creator") int creator) {
		Room r = roomService.findById(room).get();
		Shiftsession s = shiftSessionService.findById(session).get();
		Employee e = employeeService.findOne(creator).get();
		Handler h = new Handler();
		Date sqlDate;
		try {
			sqlDate = h.parseStringToDateSql(date);
			RoomsessionId rid = new RoomsessionId(room, session, sqlDate);		
			Roomsession rs = new Roomsession(rid, e);
			System.out.println(rs.toString());
			System.out.println(rs.getcreator().getPosition().getPosition());
			return new ResponseEntity<Roomsession>(rs,HttpStatus.OK);	
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}	
	}
	
	@PostMapping("create")
	public ResponseEntity<Void> create(@RequestParam("room") int room, @RequestParam("session") int session,
										@RequestParam("date") String date, @RequestParam("creator") int creator) {
		Room r = roomService.findById(room).get();
		Shiftsession s = shiftSessionService.findById(session).get();
		Employee e = employeeService.findOne(creator).get();
		
		Date sqlDate;
		try {
			sqlDate = handle.parseStringToDateSql(date);
			System.out.println(sqlDate);
			RoomsessionId rid = new RoomsessionId(room, session, sqlDate);	
			Roomsession rs = new Roomsession(rid, e);
			System.out.println(rs.toString());
			System.out.println(rs.getcreator().getPosition().getPosition());
			roomsessionService.create(rs);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}	
	}
	
	@PutMapping("subscribe")
	public ResponseEntity<?> updateSubscriber(@RequestParam("idRoom") int idRoom, @RequestParam("idSession") int idSession,
			@RequestParam("date") String date, @RequestParam("idSubscriber") int idSub){
				
		Date sqlDate;
		try {
			sqlDate = handle.parseStringToDateSql(date);
			RoomsessionId rid = new RoomsessionId(idRoom, idSession, sqlDate);
			Room room = roomService.findById(idRoom).get();
			Shiftsession session = shiftSessionService.findById(idSession).get();
			Employee subscriber = employeeService.findOne(idSub).get();
			if(subscriber == null || room == null || session == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			Roomsession rs = roomsessionService.findById(rid).get();
			if(rs == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			rs.setsubscriber(subscriber);
			rs.setapprover(null);
			roomsessionService.updateRoomSession(rs);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ParseException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}	
	}
	
	@PutMapping("approve")
	public ResponseEntity<?> updateApprover(@RequestParam("idRoom") int idRoom, @RequestParam("idSession") int idSession,
			@RequestParam("date") String date, @RequestParam("idApprover") int idApprover){
				
		Date sqlDate;
		try {
			sqlDate = handle.parseStringToDateSql(date);
			RoomsessionId rid = new RoomsessionId(idRoom, idSession, sqlDate);
			Room room = roomService.findById(idRoom).get();
			Shiftsession session = shiftSessionService.findById(idSession).get();
			Employee approver = employeeService.findOne(idApprover).get();
			if(approver == null || room == null || session == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			Roomsession rs = roomsessionService.findById(rid).get();
			if(rs == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			rs.setapprover(approver);
			roomsessionService.updateRoomSession(rs);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ParseException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// teacher xoa dang ky, xoa subscriber 
	@PutMapping("subscribe/delete")
	public ResponseEntity<?> deleteSubscribeb(@RequestParam("idRoom") int idRoom, @RequestParam("idSession") int idSession,
			@RequestParam("date") String date, @RequestParam("idSubscriber") int idSub){
				
		Date sqlDate;
		try {
			sqlDate = handle.parseStringToDateSql(date);
			RoomsessionId rid = new RoomsessionId(idRoom, idSession, sqlDate);
			Room room = roomService.findById(idRoom).get();
			Shiftsession session = shiftSessionService.findById(idSession).get();
			Employee subscriber = employeeService.findOne(idSub).get();
			if(subscriber == null || room == null || session == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			Roomsession rs = roomsessionService.findById(rid).get();
			if(rs == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			rs.setsubscriber(null);
			rs.setapprover(null);
			roomsessionService.updateRoomSession(rs);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ParseException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}	
	}
	
	// admin xoa duyet
	@PutMapping("approve/delete")
	public ResponseEntity<?> deleteApproved(@RequestParam("idRoom") int idRoom, @RequestParam("idSession") int idSession,
			@RequestParam("date") String date, @RequestParam("idApprover") int idApprover){
				
		Date sqlDate;
		try {
			sqlDate = handle.parseStringToDateSql(date);
			RoomsessionId rid = new RoomsessionId(idRoom, idSession, sqlDate);
			Room room = roomService.findById(idRoom).get();
			Shiftsession session = shiftSessionService.findById(idSession).get();
			Employee approver = employeeService.findOne(idApprover).get();
			if(approver == null || room == null || session == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			Roomsession rs = roomsessionService.findById(rid).get();
			if(rs == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			rs.setsubscriber(null);
			rs.setapprover(null);
			roomsessionService.updateRoomSession(rs);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ParseException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// admin xoa room available
		@DeleteMapping("delete")
		public ResponseEntity<?> deleteRoomsession(@RequestParam("idRoom") int idRoom, @RequestParam("idSession") int idSession,
				@RequestParam("date") String date, @RequestParam("idApprover") int idApprover){
					
			Date sqlDate;
			try {
				sqlDate = handle.parseStringToDateSql(date);
				RoomsessionId rid = new RoomsessionId(idRoom, idSession, sqlDate);
				Room room = roomService.findById(idRoom).get();
				Shiftsession session = shiftSessionService.findById(idSession).get();
				Employee approver = employeeService.findOne(idApprover).get();
				if(approver == null || room == null || session == null) {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}
				Roomsession rs = roomsessionService.findById(rid).get();
				if(rs == null) {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}
//				rs.setsubscriber(null);
//				rs.setapprover(null);
				roomsessionService.deleteRoomsession(rs);
				
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (ParseException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		
}
