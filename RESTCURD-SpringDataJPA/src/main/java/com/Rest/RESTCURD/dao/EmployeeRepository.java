package com.Rest.RESTCURD.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Rest.RESTCURD.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	// using native query and named parameters
	@Query(value="select * from employee where first_name like %:firstName%",nativeQuery = true)
	public List<Employee> getEmployeeWithFirstNameNativeSQL(@Param("firstName") String fName);
	
	// using jpql named parameters
	@Query(value="from Employee where firstName like %:firstName%")
	public List<Employee> getEmployeeWithFirstName(@Param("firstName") String fName);
	
	// using indexed parameters
	@Query(value = "from Employee where firstName=?1 and lastName=?2")
	public Employee getEmployeeWithFirstAndLastName(String fName, String lName);
	
}
