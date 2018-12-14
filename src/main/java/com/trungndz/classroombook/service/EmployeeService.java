package com.trungndz.classroombook.service;

import java.util.List;

import com.trungndz.classroombook.entities.Employees;


public interface EmployeeService {
		
	Iterable<Employees> findAll();

    List<Employees> search(String q);

    Employees findOne(int id);

    void save(Employees contact);

    void delete(int id);

	List<Employees> getAllEmployees();

}
