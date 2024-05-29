package com.Springboot.TaskManager.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.TaskManager.dao.TaskRepo;
import com.Springboot.TaskManager.model.Task;
@Service
public class TaskServiceImp implements TaskService{
	@Autowired
	private TaskRepo taskRepo;

	@Override
	public Task saveTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepo.save(task);
	}

	@Override
	public List<Task> taskList() {
		// TODO Auto-generated method stub
		List<Task> findAll=taskRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteByID(int id) {
		// TODO Auto-generated method stub
		taskRepo.deleteById(id);
		
	}

	@Override
	public Task findByID(int id) {
		// TODO Auto-generated method stub
		Optional<Task> findById=taskRepo.findById(id);
		Task task=findById.get();
		return task;
	}

	@Override
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepo.save(task);
	}

}
