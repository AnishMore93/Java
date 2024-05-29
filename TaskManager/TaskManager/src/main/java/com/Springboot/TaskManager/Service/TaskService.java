package com.Springboot.TaskManager.Service;

import java.util.List;

import com.Springboot.TaskManager.model.Task;


public interface TaskService {
	
    public Task saveTask(Task task);
	
	public List<Task> taskList();
	
	public void deleteByID(int id);
	
	public Task findByID(int id);
	
	public Task updateTask(Task task);

}
