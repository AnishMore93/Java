package com.Springboot.TaskManager.Service;

import java.util.List;

import com.Springboot.TaskManager.model.TaskAdmin;


public interface AdminService {
	
    public TaskAdmin saveAdmin(TaskAdmin taskadmin);
    public List<TaskAdmin> taskadminList();
	
	

}
