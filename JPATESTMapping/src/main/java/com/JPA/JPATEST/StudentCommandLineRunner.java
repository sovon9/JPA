package com.JPA.JPATEST;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.JPA.JPATEST.dao.InstructorRepository;
import com.JPA.JPATEST.entity.Instructor;
import com.JPA.JPATEST.entity.InstructorDetail;

import jakarta.persistence.CascadeType;

@Component
public class StudentCommandLineRunner implements CommandLineRunner{

	@Autowired
	InstructorRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Instructor saveInstructor = saveInstructor();
//		System.out.println("saved instructor: "+saveInstructor);
//		
//		System.out.println("get instructor data ");
		int id=1;
		// so it will pull the data from detail table also as default fetch behaviour of OneToOne
		// is eager type
		Instructor findInstructor = findInstructor(id);
		System.out.println("Instructor data with id: "+id+" => "+findInstructor);
		System.out.println(".........delete Intructor data for id: "+id);
		// both instructor and ionstructor_details data will be deleted
		deleteInstructor(id);
		
	}
	
	public Instructor saveInstructor()
	{
		// create new Instructor obj
		Instructor instructor = new Instructor("SS", "SS", "ss@gmail.com");
		// create new InstructorDetail obj
		instructor.setDetail(new InstructorDetail("youtube.com/ss", "coding"));
		// save to DB
	    return repository.save(instructor);
	}
	
	public Instructor findInstructor(int id)
	{
		// fetch from DB
		Optional<Instructor> optional = repository.findById(id);
		if(optional.isEmpty())
		{
			throw new RuntimeException("Data not present for id: "+id);
		}
	    return optional.get();
	}
	
	public void deleteInstructor(int id)
	{
		// fetch from DB
		repository.deleteById(id);
	}
	
}
