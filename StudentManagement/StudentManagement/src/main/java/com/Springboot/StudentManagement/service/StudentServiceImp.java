package com.Springboot.StudentManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.StudentManagement.Model.Student;
import com.Springboot.StudentManagement.dao.StudentRepo;

@Service
public class StudentServiceImp implements StudentService{
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student saveRegistered(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	@Override
	public List<Student> studentList() {
		// TODO Auto-generated method stub
		List<Student> findAll= studentRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteByID(int id) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(id);
	}

	@Override
	public Student findByID(int id) {
		// TODO Auto-generated method stub
		Optional<Student> findById= studentRepo.findById(id);
		Student student=findById.get();
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

}
