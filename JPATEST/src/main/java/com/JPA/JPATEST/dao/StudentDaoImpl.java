package com.JPA.JPATEST.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.JPA.JPATEST.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDaoImpl implements StudentDao {

	// define entity manager component
	//@Autowired // inject entitymanager using component injection 
	private EntityManager entitymanager;
	
	@Autowired // using setter injection
	public StudentDaoImpl(EntityManager entitymanager) {
		super();
		this.entitymanager = entitymanager;
	}

	/**
	 *  saving data to DB
	 */
	@Override
	@Transactional
	public void saveStudent(Student student) {
		entitymanager.persist(student);
	}
	
	/**
	 *  reading data from DB
	 */
	@Override
	public Student findbyId(int id) {
		return entitymanager.find(Student.class, id);
	}

	/**
	 *  this method gets all the student data from the table
	 */
	@Override
	public List<Student> findAll() {
		//create the query
		/*
		 *  here Student <= S is capital cause it's class name, JPQL uses entity class name
		 *  and fields
		 */
		TypedQuery<Student> query = entitymanager.createQuery("from Student", Student.class);
		return query.getResultList();
	}

	/**
	 * get all student data with firstName desc order
	 */
	@Override
	public List<Student> findAllFirstNameDesc() {
		/**
		 *  order by lastName here is the Student class element name not the table name
		 */
		// creating query
		TypedQuery<Student> stdData = entitymanager.createQuery("from Student order by firstName desc", Student.class);
		return stdData.getResultList();
	}

	/**
	 * get all students who's first name is the parameter
	 */
	@Override
	public Student findbyFirstName(String val) {
		/**
		 * here val is the named parameter, we are setting the value later
		 */
		TypedQuery<Student> stdData =  entitymanager.createQuery("from Student where firstName=:val", Student.class);
		stdData.setParameter("val", val);
		return stdData.getSingleResult();
	}

	@Override
	@Transactional
	public void update(Student student) {
		entitymanager.merge(student);
	}

	@Override
	@Transactional
	public int updateUsingJPQL(Student student) {
		//create the query
		Query query = entitymanager.createQuery("update Student set lastName=:lstName where id=:id");
		query.setParameter("lstName", student.getLastName());
		query.setParameter("id", student.getId());
		return query.executeUpdate();
	}

	@Override
	@Transactional
	public void delete(int id) {
		// find the student with id
		Student student = entitymanager.find(Student.class, id);
		// delete the student
		entitymanager.remove(student);
	}

}
