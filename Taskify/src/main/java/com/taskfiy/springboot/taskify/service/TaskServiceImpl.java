package com.taskfiy.springboot.taskify.service;

import com.taskfiy.springboot.taskify.dao.TaskDAO;
import com.taskfiy.springboot.taskify.entity.Task;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskDAO taskDAO;

    @Autowired
    public TaskServiceImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskDAO.getAllTasks();
    }

    @Override
    public Task findById(int id) {
        return taskDAO.findById(id);
    }

    @Transactional
    @Override
    public void createTask(Task task) {
        taskDAO.createTask(task);
    }

    @Transactional
    @Override
    public Task updateTask(Task task) {
        return taskDAO.updateTask(task);
    }

    @Transactional
    @Override
    public void deleteTask(int id) {
        taskDAO.deleteTask(id);
    }
}
