package com.trungndz.classroombook.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.trungndz.classroombook.entities.Employee;

public interface EmployeeDAO extends CrudRepository<Employee, Integer>{
	
	@Query("SELECT e.idemp, e.email, e.nameemp, e.position FROM Employee e")
	List<Employee> getAllEmployees();

	
	
}
