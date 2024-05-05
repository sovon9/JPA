package com.JPA.JPATEST.dao;

import java.util.List;

import com.JPA.JPATEST.entity.Student;

public interface StudentDao {

	public void saveStudent(Student student);
	
	public Student findbyId(int id);
	
	public List<Student> findAll();
	
	public List<Student> findAllFirstNameDesc();
	
	public Student findbyFirstName(String firstName);
	
	public void update(Student student);
	
	public int updateUsingJPQL(Student student);
	
	public void delete(int id);
}
