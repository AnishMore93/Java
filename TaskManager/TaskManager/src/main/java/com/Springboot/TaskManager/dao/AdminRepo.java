package com.Springboot.TaskManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.TaskManager.model.TaskAdmin;
@Repository
public interface AdminRepo extends JpaRepository<TaskAdmin,Integer>{

}
