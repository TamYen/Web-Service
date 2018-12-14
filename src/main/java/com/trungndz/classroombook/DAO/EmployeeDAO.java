package com.trungndz.classroombook.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.trungndz.classroombook.entities.Employees;

public interface EmployeeDAO extends CrudRepository<Employees, Integer>{
	
	@Query("SELECT e.idemp, e.email, e.nameemp, e.position.position FROM Employees e")
	List<Employees> getAllEmployees();

	
	
}
