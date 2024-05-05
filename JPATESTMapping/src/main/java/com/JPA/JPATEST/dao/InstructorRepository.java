package com.JPA.JPATEST.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JPA.JPATEST.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

}
