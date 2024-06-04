package com.Rest.RESTCURD.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Rest.RESTCURD.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
