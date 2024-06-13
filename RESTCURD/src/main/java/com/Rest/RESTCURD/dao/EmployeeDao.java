package com.Rest.RESTCURD.dao;

import java.util.List;

import com.Rest.RESTCURD.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	public Employee find(int id);
	
	public Employee save(Employee emp);
	
	public Employee update(Employee emp);
	
	public void delete(int id);

}
