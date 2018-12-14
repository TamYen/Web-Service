package com.trungndz.classroombook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trungndz.classroombook.entities.Employees;
import com.trungndz.classroombook.service.EmployeeService;


@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("getall")
	public ResponseEntity<List<Employees>> getAllEmp() {
		List<Employees> empList = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employees>>(empList,HttpStatus.OK);
	}

}
