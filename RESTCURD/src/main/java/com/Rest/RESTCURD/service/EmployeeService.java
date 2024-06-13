package com.Rest.RESTCURD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Rest.RESTCURD.dao.EmployeeDao;
import com.Rest.RESTCURD.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	public List<Employee> findAll()
	{
		return dao.findAll();
	}
	
	public Employee find(int id)
	{
		return dao.find(id);
	}
	
	@Transactional
	public Employee save(Employee employee)
	{
		return dao.save(employee);
	}
	
	@Transactional
	public Employee update(Employee employee)
	{
		return dao.update(employee);
	}
	
	@Transactional
	public void delete(int id)
	{
		dao.delete(id);
	}
	
}
