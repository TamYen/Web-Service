package com.trungndz.classroombook.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungndz.classroombook.DAO.EmployeeDAO;
import com.trungndz.classroombook.entities.Employee;
import com.trungndz.classroombook.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService  {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Iterable<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		return employeeDAO.getAllEmployees();
	}

	@Override
	public List<Employee> search(String q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> findOne(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(id);
	}

	@Override
	public void save(Employee contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Object> login(String email, int id) {
		return employeeDAO.login(email, id);
	}

}
