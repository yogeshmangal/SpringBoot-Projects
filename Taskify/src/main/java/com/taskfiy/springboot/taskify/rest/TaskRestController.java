package com.taskfiy.springboot.taskify.rest;

import com.taskfiy.springboot.taskify.exception.TaskNotFoundException;
import com.taskfiy.springboot.taskify.service.TaskService;
import com.taskfiy.springboot.taskify.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskRestController {
    private TaskService taskService;

    @Autowired
    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{taskId}")
    public Task getTaskById(@PathVariable int taskId) {
        Task task = taskService.findById(taskId);
        if(task == null)
            throw new TaskNotFoundException("Task id not found: " + taskId);
        return task;
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        task.setId(0);
        taskService.createTask(task);
        return task;
    }
    
    @PutMapping("/tasks")
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @DeleteMapping("/tasks/{taskId}")
    public String deleteTask(@PathVariable int taskId) {
        Task task = taskService.findById(taskId);
        if(task == null)
            throw new TaskNotFoundException("Task id not found: " + taskId);
        taskService.deleteTask(taskId);
        return "Deleted Task Id is: " + taskId;
    }
}
