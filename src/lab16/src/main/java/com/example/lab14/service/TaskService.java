package com.example.lab14.service;

import java.util.List;

import com.example.lab14.entity.Task;
import com.example.lab14.entity.Worker;
import com.example.lab14.repository.TaskRepository;
import com.example.lab14.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository repository;

    public Long createTask(Task task) {
        repository.save(task);
        return task.getId();
    }

    public List<Task> getTasks() {
        return repository.findAll();
    }


}