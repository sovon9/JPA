package com.Rest.RESTCURD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rest.RESTCURD.dao.EmployeeRepository;
import com.Rest.RESTCURD.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> findAll()
	{
		return repository.findAll();
	}
	
	public Employee find(int id)
	{
		Optional<Employee> empOptional = repository.findById(id);
		Employee emp=null;
		if(empOptional.isPresent())
		{
			emp=empOptional.get();
		}
		else
		{
			throw new RuntimeException("no employee present with id "+id);
		}
		return emp;
	}
	
	public Employee save(Employee employee)
	{
		return repository.save(employee);
	}
	
	public void delete(int id)
	{
		repository.deleteById(id);
	}
	
}
