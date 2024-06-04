package com.Rest.RESTCURD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Rest.RESTCURD.entity.Employee;
import com.Rest.RESTCURD.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee()
	{
		return service.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id)
	{
		return service.find(id);
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		// returns updated value from DB as we are using merge which returns updated val
		return service.save(employee);
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		// returns updated value from DB as we are using merge which returns updated val
		return service.save(employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id)
	{
		service.delete(id);
		return "deleted emp id: "+id;
	}
	
}
