package com.Springboot.StudentManagement.service;

import java.util.List;

import com.Springboot.StudentManagement.Model.Student;

public interface StudentService {
	
	public Student saveRegistered(Student student);
	
	public List<Student> studentList();
	
	public void deleteByID(int id);
	
	public Student findByID(int id);
	
	public Student updateStudent(Student student);

}
