package com.Springboot.TaskManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.TaskManager.model.Task;
@Repository
public interface TaskRepo extends JpaRepository<Task,Integer>{

}
