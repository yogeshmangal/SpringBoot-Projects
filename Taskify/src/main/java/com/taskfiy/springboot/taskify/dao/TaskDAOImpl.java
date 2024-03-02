package com.taskfiy.springboot.taskify.dao;

import com.taskfiy.springboot.taskify.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {
    private EntityManager entityManager;

    @Autowired
    public TaskDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Task> getAllTasks() {
        TypedQuery<Task> typedQuery = entityManager.createQuery("from Task", Task.class);
        return typedQuery.getResultList();
    }

    @Override
    public Task findById(int id) {
        Task task = entityManager.find(Task.class, id);
        return task;
    }

    @Override
    public void createTask(Task task) {
        entityManager.persist(task);
    }

    @Override
    public Task updateTask(Task task) {
        Task updatedTask = entityManager.merge(task);
        return updatedTask;
    }

    @Override
    public void deleteTask(int id) {
        Task task = entityManager.find(Task.class, id);
        entityManager.remove(task);
    }
}
