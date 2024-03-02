package com.taskfiy.springboot.taskify.service;

import com.taskfiy.springboot.taskify.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task findById(int id);
    void createTask(Task task);
    Task updateTask(Task task);
    void deleteTask(int id);
}
