package com.trungndz.classroombook.service;

import java.util.List;
import java.util.Optional;

import com.trungndz.classroombook.entities.Employee;


public interface EmployeeService {
		
	Iterable<Employee> findAll();

    List<Employee> search(String q);

    Optional<Employee> findOne(int id);

    void save(Employee contact);

    void delete(int id);

	List<Employee> getAllEmployees();

	List<Object> login(String email, int id);

}
