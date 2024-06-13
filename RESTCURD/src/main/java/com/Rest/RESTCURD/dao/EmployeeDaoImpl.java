package com.Rest.RESTCURD.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Rest.RESTCURD.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EntityManager entityManger;
	
	@Override
	public List<Employee> findAll() {
		// create the query
		// remeber to use Employee not employee as jpql uses entity name and parameters
		TypedQuery<Employee> query = entityManger.createQuery("from Employee",Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee find(int id) {
		return entityManger.find(Employee.class, id);
	}

	@Override
	public Employee save(Employee emp) {
		return entityManger.merge(emp);
	}

	@Override
	public Employee update(Employee emp) {
		return null;
	}

	@Override
	public void delete(int id) {
		// retrive the employee data
		Employee employee = entityManger.find(Employee.class, id);
		entityManger.remove(employee);;
	}

}
