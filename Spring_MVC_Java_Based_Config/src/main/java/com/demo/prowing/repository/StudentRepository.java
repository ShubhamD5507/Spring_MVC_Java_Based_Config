package com.demo.prowing.repository;

import com.demo.prowing.model.Student;

public interface StudentRepository {

	public Student addStudent(Student std);

	public Student getStudent(int id);

}
