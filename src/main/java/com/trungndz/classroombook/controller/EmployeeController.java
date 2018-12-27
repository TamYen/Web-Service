package com.trungndz.classroombook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trungndz.classroombook.entities.Employee;
import com.trungndz.classroombook.entities.Roomsession;
import com.trungndz.classroombook.service.EmployeeService;


@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("getall")
	public ResponseEntity<List<Employee>> getAllEmp() {
		List<Employee> empList = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
	}
	
	@GetMapping("all")
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> empList = (List<Employee>) employeeService.findAll();
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
	}
	
	@GetMapping("login")
	public ResponseEntity<List<Object>> login(@RequestParam("email") String email, @RequestParam("id") int id){
		List<Object> e = employeeService.login(email, id);
		if(e == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Object>>(e, HttpStatus.OK);
	}

}
