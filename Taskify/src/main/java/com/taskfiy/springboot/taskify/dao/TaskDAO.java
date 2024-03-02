package com.taskfiy.springboot.taskify.dao;

import com.taskfiy.springboot.taskify.entity.Task;

import java.util.List;

public interface TaskDAO {
    List<Task> getAllTasks();
    Task findById(int id);
    void createTask(Task task);
    Task updateTask(Task task);
    void deleteTask(int id);
}
