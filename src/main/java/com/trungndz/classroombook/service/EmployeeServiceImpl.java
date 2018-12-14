package com.trungndz.classroombook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungndz.classroombook.DAO.EmployeeDAO;
import com.trungndz.classroombook.entities.Employees;

@Service
public class EmployeeServiceImpl implements EmployeeService  {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Iterable<Employees> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}
	
	@Override
	public List<Employees> getAllEmployees(){
		return employeeDAO.getAllEmployees();
	}

	@Override
	public List<Employees> search(String q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employees findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employees contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
