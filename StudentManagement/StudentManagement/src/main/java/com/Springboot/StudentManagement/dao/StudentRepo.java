package com.Springboot.StudentManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.StudentManagement.Model.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{

}
