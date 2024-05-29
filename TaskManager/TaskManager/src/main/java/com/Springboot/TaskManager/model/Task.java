package com.Springboot.TaskManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO.SEQUENCE)
	private int id;
	private String taskname;
	private String taskdescription;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getTaskdescription() {
		return taskdescription;
	}
	public void setTaskdescription(String taskdescription) {
		this.taskdescription = taskdescription;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", taskname=" + taskname + ", taskdescription=" + taskdescription + "]";
	}
	public Task(int id, String taskname, String taskdescription) {
		super();
		this.id = id;
		this.taskname = taskname;
		this.taskdescription = taskdescription;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
