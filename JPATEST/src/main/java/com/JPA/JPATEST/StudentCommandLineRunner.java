package com.JPA.JPATEST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.JPA.JPATEST.dao.StudentDao;
import com.JPA.JPATEST.entity.Student;

import jakarta.persistence.EntityManager;

@Component
public class StudentCommandLineRunner implements CommandLineRunner{

	@Autowired
	StudentDao dao;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("..........saving student obj.............");
		Student student = new Student("SS", "Singha", "ss@gmail.com");
		Student student1 = new Student("AA", "Singha", "ss@gmail.com");
		Student student2 = new Student("UU", "Singha", "aa@gmail.com");
		System.out.println(student);
		dao.saveStudent(student);
		dao.saveStudent(student1);
		dao.saveStudent(student2);
		
		System.out.println(student);
		System.out.println("..........reading student obj.............");
		Student studentData = dao.findbyId(student.getId());
		if(null == studentData) // find method in entitymanager always return null if no data found
		{
			System.out.println("....... data not found................");
		}
		else
		{
			System.out.println("student data: "+student);
		}
		System.out.println("..........reading all student data.............");
		List<Student> allStudent = dao.findAll();
		System.out.println("All student data: "+allStudent);
		System.out.println("..........reading all student data in desc order.............");
		List<Student> allStudentdesc = dao.findAllFirstNameDesc();
		System.out.println("All student data: "+allStudentdesc);
		System.out.println("..........reading student data with first name AA.............");
		Student stdData = dao.findbyFirstName("AA");
		if(null == stdData)
		{
			System.out.println("	NO student data with first name AA. ");
		}
		System.out.println("student data with first name AA: "+stdData);
		
		System.out.println("..........updating student data.............");
		// retrieve student data based on id
		Student stdupdateval = dao.findbyId(1);
		// update student last name
		stdupdateval.setLastName("SS");
		dao.update(stdupdateval);
		// display updated student
		System.out.println("updated student data: "+stdupdateval);
		stdupdateval.setLastName("Inuyasha");
		dao.updateUsingJPQL(stdupdateval);
		System.out.println("updated student data using JPQL: "+stdupdateval);
		
		System.out.println("..........delete student data.............");
		dao.delete(3);
	}
	
}
