package com.fse.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fse.bean.ProjectManagerBean;
import com.fse.hibernate.Task;

public class TaskDAOTest {
	
	@Autowired
	TaskDAO taskDAO;
	
	@Test
	public void addTaskTest()
	{
		ProjectManagerBean projectManagerBean1 = null;
		projectManagerBean1 = new ProjectManagerBean();
		projectManagerBean1.setTask("test");
		projectManagerBean1.setTaskPriority(1);
		projectManagerBean1.setTaskStartDate(new Date());
		projectManagerBean1.setTaskEndDate(new Date());
		projectManagerBean1.setParentTask("Parent Task");
   		projectManagerBean1.setParentId(1);
		projectManagerBean1.setProjectId(1);
		projectManagerBean1.setUserId(1);
		taskDAO.addTask(projectManagerBean1);
		List taskList = taskDAO.listTask();
		assertNotNull("List should not be null",taskList);
	}
	@Test
	public void editTaskTest()
	{
		ProjectManagerBean projectManagerBean1 = null;
		projectManagerBean1 = new ProjectManagerBean();
		projectManagerBean1.setTaskId(2);
		projectManagerBean1.setTask("Edit Task");
		projectManagerBean1.setTaskPriority(1);
		projectManagerBean1.setTaskStartDate(new Date());
		projectManagerBean1.setTaskEndDate(new Date());
		projectManagerBean1.setParentTask("Parent Task");
   		projectManagerBean1.setParentId(1);
		projectManagerBean1.setProjectId(1);
		projectManagerBean1.setUserId(1);
		taskDAO.editTask(projectManagerBean1);
		Task task = taskDAO.getTask(2);
		assertEquals(task.getTask(), "Edit Task");
	}
	
	@Test
	public void endTaskTest()
	{
		taskDAO.endTask(1);
		Task task = taskDAO.getTask(1);
		assertNull("task object should  be null",task);
	}
	
	@Test
	public void listTaskTest()
	{
		ProjectManagerBean projectManagerBean1 = null;
		projectManagerBean1 = new ProjectManagerBean();
		projectManagerBean1.setTask("test");
		projectManagerBean1.setTaskPriority(1);
		projectManagerBean1.setTaskStartDate(new Date());
		projectManagerBean1.setTaskEndDate(new Date());
		projectManagerBean1.setParentTask("Parent Task");
   		projectManagerBean1.setParentId(1);
		projectManagerBean1.setProjectId(1);
		projectManagerBean1.setUserId(1);
		taskDAO.addTask(projectManagerBean1);
		List taskList = taskDAO.listTask();
		assertNotNull("List should not be null",taskList);
	}

}
