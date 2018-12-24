package com.trungndz.classroombook.DAO;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.trungndz.classroombook.entities.Employee;

public interface EmployeeDAO extends CrudRepository<Employee, Integer>{
	
	@Query("SELECT e.idemp, e.email, e.nameemp, e.position FROM Employee e")
	List<Employee> getAllEmployees();
	
	
	
	@Query("SELECT e.idemp, e.email, e.nameemp, e.position.position FROM Employee e WHERE e.email = :email and e.id = :id")
	Object login(@Param("email") String email, @Param("id") int id);
	
	
}
